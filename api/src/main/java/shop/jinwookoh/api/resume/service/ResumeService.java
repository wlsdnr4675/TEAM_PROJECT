package shop.jinwookoh.api.resume.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import shop.jinwookoh.api.artist.domain.Artist;
import shop.jinwookoh.api.resume.domain.Resume;
import shop.jinwookoh.api.resume.domain.ResumeDto;
import shop.jinwookoh.api.resume.domain.ResumeFile;
import shop.jinwookoh.api.resume.domain.ResumeFileDto;
import shop.jinwookoh.api.resume.domain.page.PageResultDto;

public interface ResumeService {

    String resumeSaveWithFile(ResumeDto resumeDto);

    String editResume(ResumeDto resumeDto);

    PageResultDto<ResumeDto, Resume> getAllDataPaging(int page);

    List<ResumeDto> getAllResume();

    PageResultDto<ResumeDto, Resume> getUserPKDataPage(Long artistId, int page);

    PageResultDto<ResumeDto, Resume> getCategoryPKDataPage(Long categoryId, int page);

    PageResultDto<ResumeDto, Resume> getCategoryAndUserDataPage(Long categoryId, Long artistId, int page);

    PageResultDto<ResumeDto, Object[]> conditionSearch(String type, String keyword, int page);

    Long countByArtistId(Long artistId);

    default ResumeFile dtoToEntityResumeFile(ResumeFileDto dto) {

        return ResumeFile.builder().fileTitle(dto.getFileTitle()).fileDetail(dto.getFileDetail())
                .fileWorkedDate(dto.getFileDetail()).uuid(dto.getUuid()).fname(dto.getFname()).repImg(dto.getRepImg())
                .build();
    }

    default ResumeDto resumeEntityToDto(Resume en) {

        return ResumeDto.builder().resumeId(en.getResumeId()).title(en.getTitle()).detail(en.getDetail())
                .selfIntroduce(en.getSelfIntroduce()).artistId(en.getArtist().getArtistId())
                .username(en.getArtist().getUsername()).name(en.getArtist().getName())
                .categoryId(en.getCategory().getCategoryId()).categoryName(en.getCategory().getCategoryName())
                .resumeFiles(en.getResumeFiles().stream().map(resumeFile -> ResumeFileDto.of(resumeFile))
                        .collect(Collectors.toList()))
                .build();
    }

    default Pageable conditionPage(int page) {

        return PageRequest.of(page <= 0 ? 0 : page - 1, 8, Sort.Direction.DESC, "resumeId");

    }

    default Function<Resume, ResumeDto> makeDtoPage() {

        return (en -> resumeEntityToDto(en));
    }

}
