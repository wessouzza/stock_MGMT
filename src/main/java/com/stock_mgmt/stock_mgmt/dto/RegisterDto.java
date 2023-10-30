package com.stock_mgmt.stock_mgmt.dto;

import com.stock_mgmt.stock_mgmt.roles.UserRoles;

public record RegisterDto(String username, String password, UserRoles role) {
}
