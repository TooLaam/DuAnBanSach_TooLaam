/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.duan1.Storage;

import com.mycompany.duan1.Entity.NhanVien;

/**
 * Trong ứng dụng Java Swing, không có cơ chế session như trong môi trường web.
 * Tuy nhiên, bạn có thể sử dụng một cơ chế lưu trữ tạm thời để lưu thông tin
 * nhân viên sau khi đăng nhập. Dưới đây là một ví dụ về cách lưu trữ thông tin
 * nhân viên vào một lớp lưu trữ tạm thời:
 */
public class SessionStorage {

    private static NhanVien loggedInNhanVien;

    public static void setLoggedInNhanVien(NhanVien nhanVien) {
        loggedInNhanVien = nhanVien;
    }

    public static NhanVien getLoggedInNhanVien() {
        return loggedInNhanVien;
    }

    public static void clearLoggedInNhanVien() {
        loggedInNhanVien = null;
    }
}
