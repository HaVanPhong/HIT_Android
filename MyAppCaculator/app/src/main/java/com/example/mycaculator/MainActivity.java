package com.example.mycaculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtInputNumber, edtResult;

    private Button btnNumber0;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;

    private Button btnCong;
    private Button btnNhan;
    private Button btnTru;
    private Button btnChia;
    private Button btnPoint;

    private Button btnClear;
    private Button btnClearAll;

    private Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KhoiTaoView();
        BatSuKien();
    }

    public void KhoiTaoView() {
        edtInputNumber = (EditText) findViewById(R.id.edtInputNumber);
        edtResult = (EditText) findViewById(R.id.edtResult);

        btnNumber0 = (Button) findViewById(R.id.btnNumber0);
        btnNumber1 = (Button) findViewById(R.id.btnNumber1);
        btnNumber2 = (Button) findViewById(R.id.btnNumber2);
        btnNumber3 = (Button) findViewById(R.id.btnNumber3);
        btnNumber4 = (Button) findViewById(R.id.btnNumber4);
        btnNumber5 = (Button) findViewById(R.id.btnNumber5);
        btnNumber6 = (Button) findViewById(R.id.btnNumber6);
        btnNumber7 = (Button) findViewById(R.id.btnNumber7);
        btnNumber8 = (Button) findViewById(R.id.btnNumber8);
        btnNumber9 = (Button) findViewById(R.id.btnNumber9);

        btnCong = (Button) findViewById(R.id.btnCong);
        btnNhan = (Button) findViewById(R.id.btnNhan);
        btnChia = (Button) findViewById(R.id.btnChia);
        btnTru = (Button) findViewById(R.id.btnTru);
        btnPoint = (Button) findViewById(R.id.btnPoint);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClearAll = (Button) findViewById(R.id.btnClearAll);

        btnResult = (Button) findViewById(R.id.btnResult);
    }

    public void BatSuKien() { //bắt sự kiện khi click vào
//        edtInputNumber và edtResult không xử lý sự kiện nên không cần setOnclickListtener (không cần nó lắng nghe gì cả)
        btnNumber0.setOnClickListener(this);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnPoint.setOnClickListener(this);

        btnClear.setOnClickListener(this);
        btnClearAll.setOnClickListener(this);

        btnResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNumber0:
                if (choPhepNhap)
                    DaAnDauBang();
                if (anAC)
                    edtInputNumber.append("0");
                else KhongChoNhap();

                break;
            case R.id.btnNumber1:
                if (choPhepNhap)
                    DaAnDauBang();
                if (anAC)
                    edtInputNumber.append("1");

                else KhongChoNhap();

                break;
            case R.id.btnNumber2:
                if (choPhepNhap)
                    DaAnDauBang();
                if (anAC)
                    edtInputNumber.append("2");

                else KhongChoNhap();
                break;
            case R.id.btnNumber3:
                if (choPhepNhap)
                    DaAnDauBang();
                if (anAC)
                    edtInputNumber.append("3");

                else KhongChoNhap();
                break;
            case R.id.btnNumber4:
                if (choPhepNhap)
                    DaAnDauBang();
                if (anAC)
                    edtInputNumber.append("4");

                else KhongChoNhap();
                break;
            case R.id.btnNumber5:
                if (choPhepNhap)
                    DaAnDauBang();
                if (anAC)
                    edtInputNumber.append("5");

                else KhongChoNhap();
                break;
            case R.id.btnNumber6:
                if (choPhepNhap)
                    DaAnDauBang();
                if (anAC)
                    edtInputNumber.append("6");

                else KhongChoNhap();
                break;
            case R.id.btnNumber7:
                if (choPhepNhap)
                    DaAnDauBang();
                if (anAC)
                    edtInputNumber.append("7");

                else KhongChoNhap();
                break;
            case R.id.btnNumber8:
                if (choPhepNhap)
                    DaAnDauBang();
                if (anAC)
                    edtInputNumber.append("8");

                else KhongChoNhap();
                break;
            case R.id.btnNumber9:
                if (choPhepNhap)
                    DaAnDauBang();
                if (anAC)
                    edtInputNumber.append("9");

                else KhongChoNhap();
                break;
            case R.id.btnCong:
                if (choPhepNhap)
                    DaAnDauBang();
                if (anAC)
                    edtInputNumber.append("+");
                else KhongChoNhap();
                break;
            case R.id.btnTru:
                if (choPhepNhap)
                    DaAnDauBang();
                if (anAC)
                    edtInputNumber.append("-");

                else KhongChoNhap();
                break;
            case R.id.btnNhan:
                if (choPhepNhap)
                    DaAnDauBang();
                if (anAC)
                    edtInputNumber.append("*");

                else KhongChoNhap();
                break;
            case R.id.btnChia:
                if (choPhepNhap)
                    DaAnDauBang();
                if (anAC)
                    edtInputNumber.append("/");

                else KhongChoNhap();
                break;
            case R.id.btnPoint:
                if (choPhepNhap)
                    DaAnDauBang();
                if (anAC)
                    edtInputNumber.append(".");

                else KhongChoNhap();
                break;
            case R.id.btnClear:
                BaseInputConnection txtCnt = new BaseInputConnection(edtInputNumber, true);
                txtCnt.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                if (choPhepNhap) DaAnDauBang();
                break;
            case R.id.btnClearAll:
                edtInputNumber.setText("");
                edtResult.setText("");
                anAC = true;
                break;
            case R.id.btnResult:
                if (checkInput()) {
                    if (TinhToan()==false) {
                        KhongChoNhap();
                        anAC = false;
                    } else {
                        TinhToan();
                        edtResult.setText(result + "");
                        choPhepNhap = true;
                    }

                } else {
                    KhongChoNhap();
                    anAC = false;

                }

                break;
            default:
                break;
        }

    }

    //kiểm tra xem phép tính nhập vào có sai cú pháp? nếu sai báo lỗi "Syntax Error" và ấn AC để Cancle
    public boolean checkInput() {
        String textInput = edtInputNumber.getText().toString();
        int size = textInput.length();
        //ký tự đầu phải khác dấu: * /
        if (textInput.charAt(0) == '*' || textInput.charAt(0) == '/') return false;
        //ký tự cuối phải là số
        if (textInput.charAt(size - 1) > '9' || textInput.charAt(size - 1) < '0') return false;
        //không được phép có 2 kí tự khác chữ số liền nhau  VD: 6*-8 is false, nhưng 2*.5=1 true
        for (int i = 0; i < size - 2; i++) {
            if (textInput.charAt(i) > '9' || textInput.charAt(i) < '0') {
                if (textInput.charAt(i + 1) != '.')
                    if (textInput.charAt(i + 1) > '9' || textInput.charAt(i + 1) < '0')
                        return false;
            }
        }

        return true;

    }

    //sau khi ấn dấu = 1 lần cho ra kết quả, khi ấn số tiếp theo sẽ thực hiện phép tính mới
    public boolean choPhepNhap = true;

    public void DaAnDauBang() {
        edtInputNumber.setText("");
        edtResult.setText("");
        choPhepNhap = false;
    }

    public boolean anAC = true;

    public void KhongChoNhap() {
        edtInputNumber.setText("Syntax Error!");
        edtResult.setText("[AC] : CANCLE ");
    }

    public double result;
    public boolean checkChiaKhong = false;

    public boolean TinhToan() {
        String str = edtInputNumber.getText().toString();
        ArrayList<Double> So = new ArrayList<>();
        ArrayList<Character> Dau = new ArrayList<>();
        ArrayList<String> chuoi = new ArrayList<>();

        int size = str.length();

        int vitri = 0;

        for (int i = 1; i < size; i++) {
            switch (Character.valueOf(str.charAt(i))) {
                case '+':
                    Dau.add('+');
                    chuoi.add(str.substring(vitri, i));
                    vitri = i + 1;
                    break;
                case '-':
                    Dau.add('-');
                    chuoi.add(str.substring(vitri, i));
                    vitri = i + 1;
                    break;
                default:
                    break;
            }
        }
        chuoi.add(str.substring(vitri, size)); //nếu chỉ có 1 số hoặc add số cuối

        int sizeChuoi = chuoi.size();
        for (int i = 0; i < sizeChuoi; i++) {
            double resultChuoi = 1;
            int vitriChuoi = 0;
            int lengthChuoi = chuoi.get(i).length();
            double t;
            int check = 0; //false -1 là chia, true 1 là nhân với số cuối cùng
            for (int j = 0; j < lengthChuoi; j++) {
                switch (chuoi.get(i).charAt(j)) {
                    case '*':
                        t = Double.parseDouble(chuoi.get(i).substring(vitriChuoi, j));
                        if (check == 0)
                            resultChuoi = t;
                        else if (check == 1)
                            resultChuoi = resultChuoi * t;
                        else if (check == -1) {
                            if (t == 0) {
                                checkChiaKhong = true;
                                return false;
                            }
                            resultChuoi = resultChuoi / t;
                        }

                        vitriChuoi = j + 1;
                        check = 1;
                        break;
                    case '/':
                        t = Double.parseDouble(chuoi.get(i).substring(vitriChuoi, j));
                        if (check == 0)
                            resultChuoi = t;
                        else if (check == 1)
                            resultChuoi = resultChuoi * t;
                        else if (check == -1) {
                            if (t == 0) {
                                checkChiaKhong = true;
                                return false;
                            }
                            resultChuoi = resultChuoi / t;
                        }

                        vitriChuoi = j + 1;
                        check = -1;
                        break;
                    default:
                        break;
                }
            }
            t = Double.parseDouble(chuoi.get(i).substring(vitriChuoi, lengthChuoi));
            if (check == 1)
                resultChuoi = resultChuoi * t;
            else if (check == -1){
                if (t == 0) {
                    checkChiaKhong = true;
                    return false;
                }
                resultChuoi = resultChuoi / t;
            }
            else if( check == 0) resultChuoi = t;

            So.add(resultChuoi);
        }


        result = So.get(0);
        //        4*3-2*2
        for (int i = 0; i < Dau.size(); i++) {
            if (Dau.get(i) == '+') result += So.get(i + 1);
            else result -= So.get(i + 1);
        }
        return true;

    }

//    //mảng chưa dấu
//    public ArrayList<Character> Dau;
//    //mảng chứa các số trong phép tính
//    public ArrayList<Double> So;
//
//    //lấy các phép tính (dấu) lưu vào Dau, lấy các số lưu vào So
//    public void LaySo_Dau(String TextOfNumber) {
//        So = new ArrayList<>();
//        Dau = new ArrayList<>();
//        int vitri = 0;
//        int size = TextOfNumber.length();
//
//        for (int i = 1; i < size; i++) { //lấy từ 1 vì có thể nhập số âm
//            switch (TextOfNumber.charAt(i)) {
//                case '+': //8+79-8
//                    Dau.add('+');
//                    So.add(Double.parseDouble(TextOfNumber.substring(vitri, i)));
//                    vitri = i + 1;
//                    break;
//                case '-':
//                    Dau.add('-');
//                    So.add(Double.parseDouble(TextOfNumber.substring(vitri, i)));
//                    vitri = i + 1;
//                    break;
//                case '*':
//                    Dau.add('*');
//                    So.add(Double.parseDouble(TextOfNumber.substring(vitri, i)));
//                    vitri = i + 1;
//                    break;
//                case '/':
//                    Dau.add('/');
//                    So.add(Double.parseDouble(TextOfNumber.substring(vitri, i)));
//                    vitri = i + 1;
//                    break;
//                default:
//                    break;
//            }
//        }
//        //số cuối cùng
//        So.add(Double.parseDouble(TextOfNumber.substring(vitri, size)));
//
//    }
//
//    public int DemDauKhacNhau(ArrayList<Character> Arrayoperator) {
//        int soDau = 0;
//        char[] dau = new char[Arrayoperator.size()];
//        dau[0] = Arrayoperator.get(0);
//        int size = Arrayoperator.size();
//        for (int i = 1; i < size; i++) {
//            for (int j = 0; j < soDau; j++)
//                if (Arrayoperator.get(i) != dau[j]) soDau++;
//        }
//        return soDau;
//    }


}