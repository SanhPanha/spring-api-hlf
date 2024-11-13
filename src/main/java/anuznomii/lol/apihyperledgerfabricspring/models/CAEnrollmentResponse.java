package anuznomii.lol.apihyperledgerfabricspring.models;
 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CAEnrollmentResponse {
    private String username; 
    private String orgName;
}
