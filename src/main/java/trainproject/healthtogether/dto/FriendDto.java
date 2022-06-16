package trainproject.healthtogether.dto;

public class FriendDto {

    private Long id;

    private String name;

    private String email;

    private String picture;

    private String nickname;

    protected FriendDto() {

    }

    public FriendDto(Long id, String name, String email, String picture, String nickname) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.nickname = nickname;
    }
}
