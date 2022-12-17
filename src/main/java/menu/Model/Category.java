package menu.Model;

import java.util.ArrayList;
import java.util.List;

public enum Category {
    JAPANESE("일식", 1, List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    KOREAN("한식", 2, List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    CHINESE("중식", 3, List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    ASIAN("아시안", 4, List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    WESTERN("양식", 5, List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private final String name;
    private final List<String> menus;
    private final int rank;
    private static final String INVALID_RANK = "올바르지 않은 순서입니다.";

    Category(String name, int rank, List<String> menus) {
        this.name = name;
        this.rank = rank;
        this.menus = menus;
    }

    public static Category getCategoryFromNumber(int rank) {
        for (Category cg : Category.values()) {
            if (cg.getRank() == rank) {
                return cg;
            }
        }
        throw new IllegalArgumentException(INVALID_RANK);
    }

    private int getRank() {
        return this.rank;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getMenus() {
        return this.menus;
    }

    static public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Category cg : values()) {
            names.add(cg.getName());
        }
        return names;
    }

    static public boolean checkFoodInMenus(String food) {
        for (Category cg : Category.values()) {
            if (cg.getMenus().contains(food)) {
                return true;
            }
        }
        return false;
    }
}
