import axios from 'axios';

const resumeList = (page) => axios.get(`http://localhost:8080/resume/list_page?page=` + page);
const resumeRegister = (resume) =>axios.post(`http://localhost:8080/resume/register`);
const resumeModify = (resume) =>axios.put(`http://localhost:8080/resume/edit`);
const resumeRead = (resumeId) =>axios.get(`http://localhost:8080/resume/read/` + resumeId);
const resumeDelete = (resume) =>axios.delete(`http://localhost:8080/resume/delete`);
const resumeSearch = (search, page) => {
    console.log("ssssss", search,  "ㅇㅇㅇㅇㅇ: ", page)
    
    return axios.get(`http://localhost:8080/resume/search/${search.type}/${encodeURIComponent(search.keyword)}?page=` + 1)} 

export default {resumeList, resumeRegister, resumeModify, resumeRead, resumeDelete , resumeSearch}; 