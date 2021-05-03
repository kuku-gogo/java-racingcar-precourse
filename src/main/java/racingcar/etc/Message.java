package racingcar.etc;

public enum Message {
    LESS_THAN_1("1 이상 입력해 주세요."),
    CAR_NAME_REQUIRED("자동차 이름은 필수값 입니다."),
    CAR_NAME_LESS_THAN_FIVE("자동차 이름은 5자 이하로만 입력해주세요."),
    ONLY_NUMBER("숫자만 입력해주세요.");

    private String text;

    private Message(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
