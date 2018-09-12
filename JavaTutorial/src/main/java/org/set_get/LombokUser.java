package org.set_get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.log4j.Log4j;

/**
 * @author code
 * @Title: LombokUser
 * @Copyright: Copyright (c) 2017
 * @Description: <br>
 * @Company: www.qdingnet.com
 * @Created on 2018/9/12下午4:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
public class LombokUser {
    private String id = null;
    private String name = null;

    @NonNull
    private String email = null;

    public static void main(String[] args) {
        log.info("test the lombok bean");

        LombokUser u = new LombokUser("001", "wity_lv", "wity_lv@sample.com");
        log.info(u.toString());

        LombokUser u2 = new LombokUser("001", "wity_lv", "wity_lv@sample.com");
        log.info(u.equals(u2));

        try {
            u.setEmail(null);
        } catch(NullPointerException ex) {
            log.info("email could not be null: " + ex.getMessage());
        }
    }
}
