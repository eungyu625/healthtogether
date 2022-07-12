package trainproject.healthtogether.dto;

import trainproject.healthtogether.domain.manytomany.UserGroup;

import java.util.List;

public class UserDto {

    private Long id;

    private String name;

    private String email;

    private List<ExerciseGroupDto> exerciseGroupDtoList;

    protected UserDto() {

    }

    /*
    * Attend 데이터를 넘겨줄 때 사용할 최소한의 User 정보
     */
    public UserDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /*
    * User 정보 데이터를 넘겨줄 때
     */
    public UserDto(Long id, String name, String email, List<UserGroup> exerciseGroupList) {
        this.id = id;
        this.name = name;
        this.email = email;


    }
}
