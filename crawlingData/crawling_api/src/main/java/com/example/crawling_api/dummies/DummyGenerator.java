package com.example.crawling_api.dummies;

import java.util.Arrays;
import java.util.List;

import static com.example.crawling_api.utils.proxy.*;

import static java.util.Collections.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;

public class DummyGenerator {
    public String makeName() {
        List<String> fname = Arrays.asList("김", "이", "박", "최", "정", "강", "조", "윤", "장", "임", "한", "오", "서", "신", "권",
                "황", "안", "송", "류", "전", "홍", "고", "문", "양", "손", "배", "조", "백", "허", "유", "남", "심", "노", "정", "하", "곽",
                "성", "차", "주", "우", "구", "신", "임", "나", "전", "민", "유", "진", "지", "엄", "채", "원", "천", "방", "공", "강", "현",
                "함", "변", "염", "양", "변", "여", "추", "노", "도", "소", "신", "석", "선", "설", "마", "길", "주", "연", "방", "위", "표",
                "명", "기", "반", "왕", "금", "옥", "육", "인", "맹", "제", "모", "장", "남", "탁", "국", "여", "진", "어", "은", "편", "구",
                "용");
        List<String> name1 = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노",
                "누", "다", "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미",
                "민", "바", "박", "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소",
                "솔", "수", "숙", "순", "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요",
                "용", "우", "원", "월", "위", "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전",
                "정", "제", "조", "종", "주", "준", "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택",
                "판", "하", "한", "해", "혁", "현", "형", "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부",
                "림", "봉", "혼", "황", "량", "린", "을", "비", "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱",
                "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼", "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식",
                "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠", "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개",
                "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
        List<String> name2 = Arrays.asList("가", "강", "건", "경", "고", "관", "광", "구", "규", "근", "기", "길", "나", "남", "노",
                "누", "다", "단", "달", "담", "대", "덕", "도", "동", "두", "라", "래", "로", "루", "리", "마", "만", "명", "무", "문", "미",
                "민", "바", "박", "백", "범", "별", "병", "보", "빛", "사", "산", "상", "새", "서", "석", "선", "설", "섭", "성", "세", "소",
                "솔", "수", "숙", "순", "숭", "슬", "승", "시", "신", "아", "안", "애", "엄", "여", "연", "영", "예", "오", "옥", "완", "요",
                "용", "우", "원", "월", "위", "유", "윤", "율", "으", "은", "의", "이", "익", "인", "일", "잎", "자", "잔", "장", "재", "전",
                "정", "제", "조", "종", "주", "준", "중", "지", "진", "찬", "창", "채", "천", "철", "초", "춘", "충", "치", "탐", "태", "택",
                "판", "하", "한", "해", "혁", "현", "형", "혜", "호", "홍", "화", "환", "회", "효", "훈", "휘", "희", "운", "모", "배", "부",
                "림", "봉", "혼", "황", "량", "린", "을", "비", "솜", "공", "면", "탁", "온", "디", "항", "후", "려", "균", "묵", "송", "욱",
                "휴", "언", "령", "섬", "들", "견", "추", "걸", "삼", "열", "웅", "분", "변", "양", "출", "타", "흥", "겸", "곤", "번", "식",
                "란", "더", "손", "술", "훔", "반", "빈", "실", "직", "흠", "흔", "악", "람", "뜸", "권", "복", "심", "헌", "엽", "학", "개",
                "롱", "평", "늘", "늬", "랑", "얀", "향", "울", "련");
        shuffle(fname);
        shuffle(name1);
        shuffle(name2);
        return fname.get(0) + name1.get(0) + name2.get(0);
    }

    public String makeUsername() {
        List<String> id = Arrays.asList("abcdefghijklmnopqrstuvwxyz1234567890".split(""));
        shuffle(id);
        id.subList(0, 4);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 8; i++) {
            sb.append(id.get(i));
        }
        /*
         * sb.insert(index, "<입력값>"); sb.replace(index, sb.length(),"<대체값>")
         * sb.delete(start-index, and-index); sb.deleteCharAt(index)
         */
        return sb.toString();
    }

    public String makeSubject() {
        List<String> school = Arrays.asList("사진학과", "광고사진영상학과", "공연사진학과", "인물사진학과", "사진영상드론학과", "사진예술과", "풍경사진학과",
                "스냅사진학과");
        shuffle(school);
        return school.get(0);
    }

    public String makeSchool() {
        List<String> school = Arrays.asList("백석예술대학교", "국제예술대학교", "정화예술대학교", "계원예술대학교", "부산예술대학교", "백제예술대학교",
                "동아방송예술대학교", "서울예술대학교", "대구예술대학교", "예원예술대학교", "추계예술대학교", "한국예술종합학교");
        shuffle(school);
        return school.get(0);
    }

    public String makeEmail() {
        List<String> email = Arrays.asList("@test.com", "@gmail.com", "@naver.com");
        shuffle(email);
        return email.get(0);
    }

    public String makeBirthday() {
        return myCalendar(1970, 2020);
    }

    private String myCalendar(int start, int end) {
        int year = rangeBelowRandom.apply(start, end);
        int month = rangeBelowRandom.apply(1, 12);
        int date30 = rangeBelowRandom.apply(1, 30);
        int date31 = rangeBelowRandom.apply(1, 31);
        int date29 = rangeBelowRandom.apply(1, 29);
        int date28 = rangeBelowRandom.apply(1, 28);
        int date = 0;
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                date = date30;
                break;
            case 2:
                date = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? date29 : date28;
                break;
            default:
                date = date31;
                break;
        }

        return year + "-" + month + "-" + date;
    }

    public String makeGender() {
        List<String> arr = Arrays.asList("M", "F", "X");
        shuffle(arr);
        return arr.get(0);
    }

    public String makeRegdate() {
        return myCalendar(2019, 2020);
    }

    public String makePhone() {
        List<String> phoneNo = Arrays.asList("0123456789".split(""));
        shuffle(phoneNo);
        phoneNo.subList(0, 4);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            sb.append(phoneNo.get(i));
        }

        return "010" + "-" + sb.toString() + "-" + sb.toString();
    }
}
