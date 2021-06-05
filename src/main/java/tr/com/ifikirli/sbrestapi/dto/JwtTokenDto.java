package tr.com.ifikirli.sbrestapi.dto;

import tr.com.ifikirli.sbrestapi.helper.JwtTokenModel;

public class JwtTokenDto {

    String accessToken;
    String refreshToken;

    public JwtTokenDto(JwtTokenModel jwtTokenModel) {

        this.accessToken = jwtTokenModel.getAccessToken();
        this.refreshToken = jwtTokenModel.getRefreshToken();
    }

    public JwtTokenDto(String accessToken, String refreshToken) {

        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
