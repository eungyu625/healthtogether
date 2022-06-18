package trainproject.healthtogether.dto;

import trainproject.healthtogether.domain.user.User;

import java.time.LocalDate;

public class AttendDto {

    private Long userId;

    private String userName;

    private String userEmail;

    private String userPicture;

    private String userNickname;

    private LocalDate joinDate;

    private Integer attendanceRate;

    protected AttendDto() {

    }

    public AttendDto(User user, LocalDate joinDate, Integer attendanceRate) {
        this.userId = user.getId();
        this.userName = user.getName();
        this.userEmail = user.getEmail();
        this.userPicture = user.getPicture();
        this.userNickname = user.getNickName();
        this.joinDate = joinDate;
        this.attendanceRate = attendanceRate;
    }
}
