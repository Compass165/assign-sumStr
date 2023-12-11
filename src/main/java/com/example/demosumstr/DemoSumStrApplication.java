package com.example.demosumstr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSumStrApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSumStrApplication.class, args);
        DemoSumStrApplication bookserviceApplication = new DemoSumStrApplication();
        String result = bookserviceApplication.sum("444", "567");
        System.out.println(result);
    }

    public String sum(String firNumStr, String secNumStr) {
        if (firNumStr == null || secNumStr == null || firNumStr.isEmpty() || secNumStr.isEmpty()) {
            throw new IllegalArgumentException("Số nhập sai!");
        }

        StringBuilder rs = new StringBuilder();
        int carry = 0;
        int maxLength = Math.max(firNumStr.length(), secNumStr.length());

        for (int i = 0; i < maxLength || carry > 0; i++) {
            int firNum = (i < firNumStr.length()) ? firNumStr.charAt(firNumStr.length() - 1 - i) - '0' : 0;
            int secNum = (i < secNumStr.length()) ? secNumStr.charAt(secNumStr.length() - 1 - i) - '0' : 0;

            int sum = firNum + secNum + carry;
            rs.append(sum % 10);
            carry = sum / 10;

            String stepMessage = "Bước " + (i + 1) + ": Lấy " + firNum + " cộng với " + secNum + " và nhớ " + carry + " được " + sum + ".";
            if (i == 0) {
                stepMessage = "Bước " + (i + 1) + ": Lấy " + firNum + " cộng với " + secNum + " được " + sum + ".";
            }

            System.out.println(stepMessage);
            System.out.println(" - Lưu " + (sum % 10) + " vào kết quả và nhớ " + (sum / 10) + ".");
        }

        return "Kết quả là: " + rs.reverse();
    }

}
