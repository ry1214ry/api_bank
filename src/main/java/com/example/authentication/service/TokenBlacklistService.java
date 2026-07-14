package com.example.authentication.service;

import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.Set;
import java.util.ConcurrentModificationException;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenBlacklistService {

    // Thread-safe set to store logged-out (blacklisted) tokens
    private final Set<String> blacklistedTokens = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public void blacklistToken(String token) {
        if (token != null) {
            // Strip "Bearer " prefix if present
            if (token.startsWith("Bearer ")) {
                token = token.substring(7);
            }
            blacklistedTokens.add(token);
        }
    }

    public boolean isBlacklisted(String token) {
        if (token == null) return false;
        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }
        return blacklistedTokens.contains(token);
    }
}