package shop.jinwookoh.api.resume.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import shop.jinwookoh.api.artist.domain.Artist;
import shop.jinwookoh.api.resume.domain.Resume;
import shop.jinwookoh.api.resume.domain.ResumeFile;
import shop.jinwookoh.api.resume.repository.search.SearchResumeRepository;

interface ResumeCustomRepository {

    @EntityGraph(attributePaths = { "artist", "category", "artist.roles" }, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT r FROM Resume r ORDER BY r.resumeId desc")
    List<Resume> getAllResume();

    @EntityGraph(attributePaths = { "artist", "category", "artist.roles" }, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT r FROM Resume r ORDER BY r.resumeId desc ")
    Page<Resume> getAllDataPaging(Pageable pageable);

    @EntityGraph(attributePaths = { "category", "artist.roles" }, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT r FROM Resume r  WHERE r.artist.artistId= :artistId")
    Page<Resume> getUserPKDataPage(@Param("artistId") Long artistId, Pageable pageable);

    @EntityGraph(attributePaths = { "artist", "category", "artist.roles" }, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT r FROM Resume r WHERE r.category.categoryId=:categoryId")
    Page<Resume> getCategoryPKDataPage(@Param("categoryId") Long categoryId, Pageable pageable);

    @EntityGraph(attributePaths = { "artist", "category", "artist.roles" }, type = EntityGraph.EntityGraphType.FETCH)
    @Query("SELECT r FROM Resume r WHERE r.category.categoryId= :categoryId AND r.artist.artistId = :artistId")
    Page<Resume> getCategoryAndUserDataPage(@Param("categoryId") Long categoryId, @Param("artistId") Long artistId,
            Pageable pageable);
}

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long>, ResumeCustomRepository, SearchResumeRepository {

    @EntityGraph(attributePaths = { "artist", "category", "artist.roles" }, type = EntityGraph.EntityGraphType.FETCH)
    Optional<Resume> findById(@Param("resumeId") Long resumeId);

    @Query("SELECT count(resumeId) as cnt FROM Resume  WHERE artist.artistId= :artistId AND regdate between '2021-01-01' and '2021-12-31'")
    Long countByArtistId(@Param("artistId") Long artistId);

}
