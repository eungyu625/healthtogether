package trainproject.healthtogether.dto;

public class FriendDto {

    private Long id;

    private String name;

    private String email;

    protected FriendDto() {

    }

    public FriendDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
