package com.ayni.user_service.Iam.infrastructure.hashing.bcrypt;

import com.ayni.user_service.Iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
