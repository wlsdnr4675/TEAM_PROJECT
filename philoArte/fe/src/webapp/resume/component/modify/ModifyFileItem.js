import React, { useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { useParams } from 'react-router';
import { changeFileList, delFileList } from 'webapp/resume/reducer/resume.reducer';

const ModifyFileItem = ({ uuid, fname, fileDetail, fileTitle, fileWorkedDate, resumeFileId, repImg }) => {
    const { resumeId } = useParams();
    const dispatch = useDispatch();
    const fileList = useSelector((state) => state.resumes.current.resumeFiles);

    const [resumeFile, setResumeFile] = useState({
        fileTitle: fileTitle,
        fileDetail: fileDetail,
        fileWorkedDate: fileWorkedDate,
        uuid: uuid,
        fname: fname,
        resumeFileId: resumeFileId,
        repImg: repImg,
        resumeId: resumeId,
    });
    console.log('resumeId:', resumeId);
    console.log('fanme', resumeFile);

    const resumeFileChange = (e) => {
        e.stopPropagation();
        e.preventDefault();
        const { name, value } = e.target;
        resumeFile[name] = value;
        setResumeFile({ ...resumeFile });
        console.log('resumeFileChange : ', resumeFile);
        dispatch(changeFileList(resumeFile));
    };

    const repTrue = (e) => {
        e.stopPropagation();
        e.preventDefault();
        resumeFile.repImg = !resumeFile.repImg;
        setResumeFile({ ...resumeFile });
        dispatch(changeFileList(resumeFile));
    };

    const resumeFileDelete = (e) => {
        e.stopPropagation();
        e.preventDefault();
        dispatch(delFileList(resumeFile));
    };

    return (
        <>
            <div className="container">
                <div className="col-md-12 col-sm-12 col-xs-12 mb-20 xs-mb-50">
                    <img src={`http://localhost:8080/resume_file/display?fileName=${resumeFile.uuid + '_' + resumeFile.fname}`} />
                    <br />
                    {resumeFile.fname}
                    <button className="btn mt-10" style={{ marginLeft: '10px' }} value={resumeFile.repImg} name="repImg" onClick={(e) => resumeFileDelete(e)}>
                        ??????????????? ??????
                    </button>
                    <br />
                    <label className="font-20px">?????? ?????? ??????</label>
                    <input type="text" name="fileWorkedDate" style={{ color: 'black', wordWrap: 'break-word' }} value={resumeFile.fileWorkedDate} placeholder="fileWorkedDate" onChange={(e) => resumeFileChange(e)} />
                    <label className="font-20px">?????? ??????</label>
                    <input type="text" name="fileTitle" style={{ color: 'black' }} value={resumeFile.fileTitle} placeholder="fileTitle" onChange={(e) => resumeFileChange(e)} />
                    <label className="font-20px">?????? ????????????</label>
                    <textarea type="text" name="fileDetail" style={{ color: 'black', height: '200px' }} wrap="on" value={resumeFile.fileDetail} placeholder="fileDetail" onChange={(e) => resumeFileChange(e)} />
                    {!resumeFile.repImg ? (
                        <>
                            <label className="font-20px">?????????????????? ?????????????????????????</label>
                            <br />
                            <button className="btn btn-md btn-dark-outline btn-square mt-10" value={resumeFile.repImg} name="repImg" onClick={(e) => repTrue(e)}>
                                CHECK
                            </button>
                        </>
                    ) : (
                        <>
                            <label className="font-20px">??????????????? ????????? ?????????????????????????</label>
                            <br />
                            <button className="btn btn-md btn-color btn-square mt-10" value={resumeFile.repImg} name="repImg" onClick={(e) => repTrue(e)}>
                                CANCEL
                            </button>
                        </>
                    )}
                </div>
            </div>
        </>
    );
};

export default ModifyFileItem;