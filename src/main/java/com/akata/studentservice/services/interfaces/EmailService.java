package com.akata.studentservice.services.interfaces;

import com.akata.studentservice.model.EmailModel;

public interface EmailService {
    boolean send(EmailModel emailModel);
}
