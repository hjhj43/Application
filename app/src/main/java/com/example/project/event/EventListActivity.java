package com.example.project.event;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.project.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class EventListActivity extends AppCompatActivity {

    private ListView listview;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_listview);

        adapter=new ListViewAdapter();

        listview=(ListView)findViewById(R.id.listview);
        listview.setAdapter(adapter);

        adapter.addItem("2021 삼성생명 금융영업 전문가 과정 16-2기 모집",
                "대상: 제한없음\n" +
                        "주최: 삼성생명\n" +
                        "모집 기간: 2021.04.05~2021.06.25",
                "* 활동소개\n" +
                        "1) 삼성생명 금융영업전문가과정 16-2기\n" +
                        "2) 대한민국 최고의 기업 삼성생명에서 주관하는 대외활동 \n" +
                        "* 활동내용\n" +
                        "1) 금융트렌드와 금융상품의 이해\n" +
                        "2) 삼성의 교육과 조직문화 경험\n" +
                        "3) 거시경제와 금융트렌드 이해\n" +
                        "4) 금융 관련 비전공자도 재무설계 및 투자지식 함양\n" +
                        "5) 2020 투자의 지혜",
                "samsung",
                "https://forms.gle/nWjfBiaLAWReKmCM9"
        );
        adapter.addItem("2021년 문화, 관광 빅 데이터 분석대회",
                "대상: 대학생, 기타\n" +
                        "주최: 한국문화관광연구원\n" +
                        "모집 기간: 2021.06.09~2021.06.28",
                "* 대회주제\n" +
                        "1) 코로나19 이후, 뉴 노멀 시대의 문화, 관광\n" +
                        "2) 데이터를 기반으로 '해당 분야의 현황을 분석, 진단하고 " +
                        "변화를 예측'하여 정책적으로 활용 가능한 결과 제시 \n" +
                        "* 활동 데이터 목록\n" +
                        "1) 국가승인통계: 국민문화예술활동조사, 국민여가활동조사\n" +
                        "2) 민간 데이터: 신한카드 데이터\n" +
                        "3) 공공 데이터: 기상청 국가기후데이터, 행정안전부 빅데이터\n" +
                        "4) 기타: SNS 키워드 분석",
                "bigdata",
                "http://www.tourbigdata.kr/"
        );
        adapter.addItem("제8회 국립생태원 생태동아리 탐구대회",
                "대상: 청소년\n" +
                        "주최: 국립생태원\n" +
                        "모집 기간: 2021.05.31~2021.06.24",
                "* 대회주제\n" +
                        "- 우리 생활에 유익한 '생태모방'아이디어 제안\n" +
                        "* 심사기준\n" +
                        "1) 타당성: 논리적으로 타당한가?\n" +
                        "2) 적절성: 주제와 관련 되는가?\n" +
                        "3) 창의성: 참신한가?\n" +
                        "4) 효과성: 실제로 실현가능성이 있는가?\n" +
                        "5) 잠재성: 기대효과가 높은가?",
                "environment",
                "http://www.ecostudy.co.kr/"
        );
        adapter.addItem("2021 MZ 인공지능 해커톤 대회",
                "대상: 일반인, 대학생\n" +
                        "주최: 한국지능정보사회 진흥원\n" +
                        "모집 기간: 2021.01.11~2021.01.24",
                "*공모 및 접수 : 2021. 1. 11(월) ~ 1. 24(일)\n" +
                        "* 참가접수 :  대학(원)생, 관련분야 종사자 및 일반인(국내 거주 외국인 포함)으로 구성된 팀\n" +
                        "* 해외거주 한국인 참가 불가\n" +
                        "* 기존 진행되었던 인공지능 해커톤 대회(AI 장치용 STT를 위한 의도분류) 참가자는 중복참여 불가(기존 대회에 신청 후 제출을 하지 않았다 하더라도 이번 대회 참가 불가)\n" +
                        "* 공모전 도전자들에게 전하고 싶은 말은? 많은 참여 부탁드립니다.",
                "mz_hackathon",
                "https://mzhackathonmedical.co.kr/mzmedical/"
        );
        adapter.addItem("2021년 굿네이버스 대구경북본부 대학생자원봉사동아리 한빛 모집",
                "대상: 대학생\n" +
                        "주최: 굿네이버스 대구경북본부\n" +
                        "모집 기간: 2021.02.05~2021.02.24",
                "* 활동내용\n" +
                        "1) 팀별활동 : 세계시민교육 강사, 희망원정대, 사회공헌캠페인\n" +
                        "2) 전체활동 : 발대식, 체육대회, 단합회, 송년회 \n" +
                        "* 활동특전\n" +
                        "1) 수료증 발급\n" +
                        "2) 우수자원봉사자 표창장 수여\n" +
                        "3) VMS자원봉사시간 등록\n" +
                        "4) 특강(취업, NGO관련, 기타 외부 특강)\n" +
                        "5) 다양한 인적 네트워크 형성 및 소정의 기념품 제공",
                "goodvolun",
                "http://daegukb.goodneighbors.kr/gndaegukb/b"
        );
        adapter.notifyDataSetChanged();

        listview.setOnItemClickListener((AdapterView.OnItemClickListener)(new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView parent, View view, int position, long id) {
                Toast.makeText((Context)EventListActivity.this, (CharSequence)adapter.getTitle(position), Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(), EventItemActivity.class);
                intent.putExtra("title", adapter.getTitle(position));
                intent.putExtra("content", adapter.getContent(position));
                intent.putExtra("detail", adapter.getDetail(position));
                intent.putExtra("link", adapter.getLink(position));
                intent.putExtra("mainImageView", adapter.getMainImageView(position));
                startActivity(intent);
            }
        }));
    }
}
