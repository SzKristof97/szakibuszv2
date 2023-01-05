package me.szaki.szakibuszv2.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is responsible for the error responses.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private int statusCode;
    private String message;

    public ErrorResponse(String message) {
        super();
        this.message = message;
    }
}
