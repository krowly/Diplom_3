package Pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PojoUser {
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String password;

    private String accessToken;
    private String refreshToken;
    private String authorization;

    public PojoUser authorize()
    {
        PojoUser pj = new PojoUser();
        pj.setEmail(email);
        pj.setPassword(password);
        //pj.setAuthorization(authorization);
        return pj;
    }
}
