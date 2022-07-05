package trainproject.healthtogether.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModifyRequestDto {
    private String nickName;
    private String picture;
}
