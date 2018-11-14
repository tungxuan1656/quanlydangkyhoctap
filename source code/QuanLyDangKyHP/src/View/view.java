package View;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.*;
import Model.*;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfTenSV;
	private JTextField tfKhoa;
	private JTextField tfMssv;
	private JTextField tfLop;
	private JTextField tfNgaySinh;
	private JTextField tfThanhPho;
	private JTextField tfMaHP;
	private JTextField tfTenHP;
	private JTextField tfTiet;
	private JTextField tfThu;
	private JTextField tfPhong;
	private JTextField tfTin;
	private JTextField tfMssvDK;
	private JTextField tfMaLopDK;
	private JTextField tfMaLop;
	private JTable tbSV;
	private JTable tbDK;
	private JTable tbLH;
	
	private ArrayList<SinhVien> listsv, searchsv;
	private ArrayList<LopHoc> listlop, searchlh;
	private ArrayList<DangKy> listdk, searchdk;
	

	public view() {
		// set look and feel
		setResizable(false);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		// create
		initCompose();
		
		listSubject();
		
		ShowTable();
	}
	
	private void listSubject() {
		listsv = new SinhVienDAO().getListSV();
		listlop = new LopHocDAO().getListLop();
		listdk = new DangKyDAO().getListDK();
	}
	
	int i=1, j=1, k=1;
	
	private void ShowTable() {
		i=1;
		j=1;
		k=1;
		
		for (SinhVien sv: listsv) {
			((DefaultTableModel) tbSV.getModel()).addRow(new Object[] {
					i++, sv.getMssv(), sv.getTensv(), new SimpleDateFormat("dd/MM/yyyy").format(sv.getNgaysinh()), sv.getKhoa(), sv.getLop(), sv.getThanhpho()});
		}
		
		for (LopHoc lh: listlop) {
			((DefaultTableModel) tbLH.getModel()).addRow(new Object[] {
					j++, lh.getMalop(), lh.getMahp(), lh.getTenhp(), lh.getTinchi(), lh.getTiet(), lh.getThu(), lh.getPhonghoc()});
		}
		
		for (DangKy dk: listdk) {
			((DefaultTableModel) tbDK.getModel()).addRow(new Object[] {
					k++, dk.getMssv(), dk.getTensv(), dk.getMalop(), dk.getMahp(), dk.getTenhp(), dk.getTin(), dk.getTiet(), dk.getThu(), dk.getPhonghoc()});
		}
	}
	
	private void ResetTable() {
		((DefaultTableModel) tbSV.getModel()).setRowCount(0);
		((DefaultTableModel) tbLH.getModel()).setRowCount(0);
		((DefaultTableModel) tbDK.getModel()).setRowCount(0);
	}
	
	private void initCompose() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 645);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabView = new JTabbedPane(JTabbedPane.TOP);
		tabView.setBounds(0, 0, 1100, 600);
		contentPane.add(tabView);
		
		JPanel pnSinhVien = new JPanel();
		pnSinhVien.setBackground(UIManager.getColor("CheckBox.background"));
		tabView.addTab("Sinh Vi\u00EAn", null, pnSinhVien, null);
		pnSinhVien.setLayout(null);
		
		JLabel lbHeaderSV = new JLabel("Th\u00F4ng Tin Sinh Vi\u00EAn");
		lbHeaderSV.setFont(new Font("Verdana", Font.BOLD, 13));
		lbHeaderSV.setBounds(482, 11, 275, 18);
		pnSinhVien.add(lbHeaderSV);
		
		JPanel pnInfoSV = new JPanel();
		pnInfoSV.setBounds(0, 40, 300, 500);
		pnSinhVien.add(pnInfoSV);
		pnInfoSV.setLayout(null);
		
		tfMssv = new JTextField();
		tfMssv.setBounds(80, 78, 200, 20);
		pnInfoSV.add(tfMssv);
		tfMssv.setColumns(10);
		
		tfTenSV = new JTextField();
		tfTenSV.setBounds(80, 123, 200, 20);
		pnInfoSV.add(tfTenSV);
		tfTenSV.setColumns(10);
		
		tfKhoa = new JTextField();
		tfKhoa.setBounds(80, 166, 200, 20);
		pnInfoSV.add(tfKhoa);
		tfKhoa.setColumns(10);
		
		tfLop = new JTextField();
		tfLop.setColumns(10);
		tfLop.setBounds(80, 214, 200, 20);
		pnInfoSV.add(tfLop);
		
		tfNgaySinh = new JTextField();
		tfNgaySinh.setColumns(10);
		tfNgaySinh.setBounds(80, 262, 200, 20);
		pnInfoSV.add(tfNgaySinh);
		
		tfThanhPho = new JTextField();
		tfThanhPho.setColumns(10);
		tfThanhPho.setBounds(80, 307, 200, 20);
		pnInfoSV.add(tfThanhPho);
		
		JLabel lbMssv = new JLabel("MSSV");
		lbMssv.setBounds(10, 81, 60, 14);
		pnInfoSV.add(lbMssv);
		
		JLabel lbTenSV = new JLabel("H\u1ECD t\u00EAn");
		lbTenSV.setBounds(10, 126, 60, 14);
		pnInfoSV.add(lbTenSV);
		
		JLabel lbKhoa = new JLabel("Kh\u00F3a");
		lbKhoa.setBounds(10, 169, 60, 14);
		pnInfoSV.add(lbKhoa);
		
		JLabel lbLop = new JLabel("L\u1EDBp");
		lbLop.setBounds(10, 217, 60, 14);
		pnInfoSV.add(lbLop);
		
		JLabel lbNgaySinh = new JLabel("Ng\u00E0y Sinh");
		lbNgaySinh.setBounds(10, 265, 60, 14);
		pnInfoSV.add(lbNgaySinh);
		
		JLabel lbThanhPho = new JLabel("Th\u00E0nh Ph\u1ED1");
		lbThanhPho.setBounds(10, 310, 60, 14);
		pnInfoSV.add(lbThanhPho);
		
		JButton btnSearchSV = new JButton("T\u00ECm Ki\u1EBFm");
		btnSearchSV.setBounds(200, 395, 89, 23);
		pnInfoSV.add(btnSearchSV);
		
		JButton btnThemSV = new JButton("Th\u00EAm SV");
		btnThemSV.setBounds(10, 395, 89, 23);
		pnInfoSV.add(btnThemSV);
		
		JButton btnXoaSV = new JButton("X\u00F3a SV");
		btnXoaSV.setBounds(105, 395, 89, 23);
		pnInfoSV.add(btnXoaSV);
		
		JButton btDatLaiSV = new JButton("Đặt Lại");
		btDatLaiSV.setBounds(10, 435, 89, 23);
		pnInfoSV.add(btDatLaiSV);
		
		JScrollPane spSV = new JScrollPane();
		spSV.setBounds(310, 40, 775, 500);
		pnSinhVien.add(spSV);

		JPanel pnLopHoc = new JPanel();
		tabView.addTab("Lớp Học", null, pnLopHoc, null);
		pnLopHoc.setLayout(null);
		pnLopHoc.setBackground(SystemColor.menu);
		
		JLabel lnHeaderLH = new JLabel("Thông Tin Lớp Học");
		lnHeaderLH.setFont(new Font("Verdana", Font.BOLD, 13));
		lnHeaderLH.setBounds(482, 11, 275, 18);
		pnLopHoc.add(lnHeaderLH);
		
		JScrollPane spLH = new JScrollPane();
		spLH.setBounds(310, 40, 775, 500);
		pnLopHoc.add(spLH);
		
		JPanel pnInfoLH = new JPanel();
		pnInfoLH.setLayout(null);
		pnInfoLH.setBounds(0, 40, 300, 500);
		pnLopHoc.add(pnInfoLH);
		
		tfMaHP = new JTextField();
		tfMaHP.setColumns(10);
		tfMaHP.setBounds(80, 166, 200, 20);
		pnInfoLH.add(tfMaHP);
		
		tfTenHP = new JTextField();
		tfTenHP.setColumns(10);
		tfTenHP.setBounds(80, 123, 200, 20);
		pnInfoLH.add(tfTenHP);
		
		tfTiet = new JTextField();
		tfTiet.setColumns(10);
		tfTiet.setBounds(80, 214, 200, 20);
		pnInfoLH.add(tfTiet);
		
		tfThu = new JTextField();
		tfThu.setColumns(10);
		tfThu.setBounds(80, 262, 200, 20);
		pnInfoLH.add(tfThu);
		
		tfPhong = new JTextField();
		tfPhong.setColumns(10);
		tfPhong.setBounds(80, 304, 200, 20);
		pnInfoLH.add(tfPhong);
		
		tfTin = new JTextField();
		tfTin.setColumns(10);
		tfTin.setBounds(80, 352, 200, 20);
		pnInfoLH.add(tfTin);
		
		tfMaLop = new JTextField();
		tfMaLop.setColumns(10);
		tfMaLop.setBounds(80, 78, 200, 20);
		pnInfoLH.add(tfMaLop);
		
		JLabel lbMaHP = new JLabel("M\u00E3 HP");
		lbMaHP.setBounds(10, 169, 60, 14);
		pnInfoLH.add(lbMaHP);
		
		JLabel lbTenHP = new JLabel("T\u00EAn HP");
		lbTenHP.setBounds(10, 126, 60, 14);
		pnInfoLH.add(lbTenHP);
		
		JLabel lbTiet = new JLabel("Tiết");
		lbTiet.setBounds(10, 217, 60, 14);
		pnInfoLH.add(lbTiet);
		
		JLabel lbThu = new JLabel("Thứ");
		lbThu.setBounds(10, 265, 60, 14);
		pnInfoLH.add(lbThu);
		
		JLabel lbPhong = new JLabel("Ph\u00F2ng");
		lbPhong.setBounds(10, 310, 60, 14);
		pnInfoLH.add(lbPhong);
		
		JLabel lbTin = new JLabel("S\u1ED1 t\u00EDn ch\u1EC9");
		lbTin.setBounds(10, 355, 60, 14);
		pnInfoLH.add(lbTin);
		
		JLabel lbMaLop = new JLabel("Mã lớp");
		lbMaLop.setBounds(10, 81, 60, 14);
		pnInfoLH.add(lbMaLop);
		
		JButton btSearchLH = new JButton("T\u00ECm Ki\u1EBFm");
		btSearchLH.setBounds(200, 395, 89, 23);
		pnInfoLH.add(btSearchLH);
		
		JButton btThemlop = new JButton("Thêm Lớp");
		btThemlop.setBounds(10, 395, 89, 23);
		pnInfoLH.add(btThemlop);
		
		JButton btXoalop = new JButton("Xóa lớp");
		btXoalop.setBounds(105, 395, 89, 23);
		pnInfoLH.add(btXoalop);
		
		JButton btDatLaiLH = new JButton("Đặt Lại");
		btDatLaiLH.setBounds(10, 435, 89, 23);
		pnInfoLH.add(btDatLaiLH);
		
		JPanel pnDangKy = new JPanel();
		pnDangKy.setLayout(null);
		pnDangKy.setBackground(SystemColor.menu);
		tabView.addTab("\u0110\u0103ng K\u00FD", null, pnDangKy, null);
		
		JLabel lbHeaderDK = new JLabel("Th\u00F4ng Tin \u0110\u0103ng K\u00FD");
		lbHeaderDK.setFont(new Font("Verdana", Font.BOLD, 13));
		lbHeaderDK.setBounds(482, 11, 275, 18);
		pnDangKy.add(lbHeaderDK);
		
		JScrollPane spDK = new JScrollPane();
		spDK.setBounds(310, 40, 775, 500);
		pnDangKy.add(spDK);
		
		JPanel pnInfoDK = new JPanel();
		pnInfoDK.setLayout(null);
		pnInfoDK.setBounds(0, 40, 300, 500);
		pnDangKy.add(pnInfoDK);
		
		tfMssvDK = new JTextField();
		tfMssvDK.setColumns(10);
		tfMssvDK.setBounds(80, 78, 200, 20);
		pnInfoDK.add(tfMssvDK);
		
		tfMaLopDK = new JTextField();
		tfMaLopDK.setColumns(10);
		tfMaLopDK.setBounds(80, 123, 200, 20);
		pnInfoDK.add(tfMaLopDK);
		
		JLabel lbMssvDK = new JLabel("MSSV");
		lbMssvDK.setBounds(10, 81, 60, 14);
		pnInfoDK.add(lbMssvDK);
		
		JLabel lbMaHPDK = new JLabel("Mã Lớp");
		lbMaHPDK.setBounds(10, 126, 60, 14);
		pnInfoDK.add(lbMaHPDK);
		
		JButton btSearchDK = new JButton("T\u00ECm Ki\u1EBFm");
		btSearchDK.setBounds(200, 395, 89, 23);
		pnInfoDK.add(btSearchDK);
		
		JButton btThemDK = new JButton("ĐK mới");
		btThemDK.setBounds(10, 395, 89, 23);
		pnInfoDK.add(btThemDK);
		
		JButton btXoaDK = new JButton("Xóa ĐK");
		btXoaDK.setBounds(105, 395, 89, 23);
		pnInfoDK.add(btXoaDK);
		
		JButton btDatLaiDK = new JButton("Đặt Lại");
		btDatLaiDK.setBounds(10, 435, 89, 23);
		pnInfoDK.add(btDatLaiDK);
		
		// create Table
		
		tbSV = new JTable();
		tbSV.setEnabled(false);
		tbSV.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "MSSV", "Họ tên", "Ngày sinh", "Khóa", "Lớp", "Thành phố"
			}
		));
		tbSV.setFillsViewportHeight(true);
		tbSV.getColumnModel().getColumn(0).setMaxWidth(30);
		tbSV.getColumnModel().getColumn(1).setMaxWidth(80);
		tbSV.getColumnModel().getColumn(3).setMaxWidth(80);
		tbSV.getColumnModel().getColumn(4).setMaxWidth(50);
		tbSV.getColumnModel().getColumn(5).setMinWidth(150);
		tbSV.setRowHeight(25);
		spSV.setViewportView(tbSV);
		
		tbLH = new JTable();
		tbLH.setEnabled(false);
		tbLH.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"STT", "Mã lớp", "Mã HP", "Tên HP", "Số tín", "Tiết", "Thứ", "Phòng"
				}
			));
		tbLH.setFillsViewportHeight(true);
		tbLH.getColumnModel().getColumn(0).setMaxWidth(30);
		tbLH.getColumnModel().getColumn(1).setMaxWidth(80);
		tbLH.getColumnModel().getColumn(2).setMaxWidth(80);
		tbLH.getColumnModel().getColumn(4).setMaxWidth(50);
		tbLH.getColumnModel().getColumn(5).setMaxWidth(80);
		tbLH.getColumnModel().getColumn(6).setMaxWidth(80);
		
		tbLH.setRowHeight(25);
		spLH.setViewportView(tbLH);
		
		tbDK = new JTable();
		tbDK.setEnabled(false);
		tbDK.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"STT", "MSSV", "Tên SV", "Mã Lớp", "Mã HP","Tên HP", "Số Tín", "Tiết", "Thứ", "Phòng"
				}
			));
		tbDK.setFillsViewportHeight(true);
		tbDK.getColumnModel().getColumn(0).setMaxWidth(30);
		tbDK.getColumnModel().getColumn(1).setMaxWidth(70);
		tbDK.getColumnModel().getColumn(3).setMaxWidth(70);
		tbDK.getColumnModel().getColumn(4).setMaxWidth(70);
		tbDK.getColumnModel().getColumn(4).setMinWidth(150);
		tbDK.getColumnModel().getColumn(6).setMaxWidth(50);
		tbDK.getColumnModel().getColumn(7).setMaxWidth(80);
		tbDK.getColumnModel().getColumn(8).setMaxWidth(80);
		tbDK.getColumnModel().getColumn(9).setMaxWidth(80);
		tbDK.setRowHeight(25);
		spDK.setViewportView(tbDK);
		
		
		//event DatLai
		btDatLaiSV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tfMssv.setText("");
				tfTenSV.setText("");
				tfNgaySinh.setText("");
				tfKhoa.setText("");
				tfLop.setText("");
				tfThanhPho.setText("");
				ResetTable();
				ShowTable();
			}
		});
		btDatLaiLH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tfMaHP.setText("");
				tfTenHP.setText("");
				tfMaLop.setText("");
				tfTiet.setText("");
				tfThu.setText("");
				tfPhong.setText("");
				tfTin.setText("");
				ResetTable();
				ShowTable();
			}
		});
		btDatLaiDK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tfMssvDK.setText("");
				tfMaLopDK.setText("");
				ResetTable();
				ShowTable();
			}
		});
		
		
		// event ThemSV
		btnThemSV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tfMssv.getText().equals("") || tfTenSV.getText().equals("") || 
						tfNgaySinh.getText().equals("") || tfKhoa.getText().equals("") || 
						tfLop.getText().equals("") || tfThanhPho.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane, "Không được để trống!");
				}
				else {
					SinhVien s = new SinhVien();
			        s.setMssv(tfMssv.getText());
			        s.setTensv(tfTenSV.getText());
			        try {
						s.setNgaysinh(new SimpleDateFormat("dd/MM/yyyy").parse(tfNgaySinh.getText()));
					} catch (ParseException ee) {
						ee.printStackTrace();
					}
			        s.setKhoa(tfKhoa.getText());
			        s.setLop(tfLop.getText());
			        s.setThanhpho(tfThanhPho.getText());
			        
			        if(new SinhVienDAO().addSinhVien(s)){
			            JOptionPane.showMessageDialog(rootPane, "Thêm thành công!");
			            listsv.add(s); // them vao danh sach SV
			            ((DefaultTableModel) tbSV.getModel()).addRow(new Object[] {
								i++, s.getMssv(), s.getTensv(), new SimpleDateFormat("dd/MM/yyyy").format(s.getNgaysinh()), s.getKhoa(), s.getLop(), s.getThanhpho()});
			        } else{
			            JOptionPane.showMessageDialog(rootPane, "MSSV đã tồn tại!");
			        }
				}		
			}
		});
		
		// event XoaSV
		btnXoaSV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (tfMssv.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane, "Không tồn tại MSSV!");
				}
				else {
					if (new SinhVienDAO().deleteSinhVien(tfMssv.getText())) {
						JOptionPane.showMessageDialog(rootPane, "Xóa thành công!");
						listSubject();
						ResetTable();
						ShowTable();
					}
					else JOptionPane.showMessageDialog(rootPane, "Gặp lỗi từ SQL Server!");
				}
			}
		});
		// event SearchSV
		btnSearchSV.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int count = 1;
				searchsv =new SinhVienDAO().searchListSV(tfMssv.getText(), tfTenSV.getText(), tfKhoa.getText(), tfLop.getText(), tfThanhPho.getText());
				((DefaultTableModel) tbSV.getModel()).setRowCount(0);
				
				for (SinhVien sv: searchsv) {
					((DefaultTableModel) tbSV.getModel()).addRow(new Object[] {
							count++, sv.getMssv(), sv.getTensv(), new SimpleDateFormat("dd/MM/yyyy").format(sv.getNgaysinh()), sv.getKhoa(), sv.getLop(), sv.getThanhpho()});
				}
			}
		});
		
		// event ThemHP
		btThemlop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (tfMaHP.getText().equals("") || tfTenHP.getText().equals("") || tfMaLop.getText().equals("") || 
						tfTin.getText().equals("") || tfTiet.getText().equals("") || 
						tfThu.getText().equals("") || tfPhong.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane, "Không được để trống Mã Lớp!");
				}
				else {
					LopHoc lh = new LopHoc();
					lh.setMahp(tfMaHP.getText());
					lh.setTenhp(tfTenHP.getText());
					lh.setMalop(tfMaLop.getText());
					lh.setTinchi(Integer.parseInt(tfTin.getText()));
					lh.setTiet(tfTiet.getText());
					lh.setThu(tfThu.getText());
					lh.setPhonghoc(tfPhong.getText());
			        
			        if(new LopHocDAO().addLopHoc(lh)){
			            JOptionPane.showMessageDialog(rootPane, "Thêm thành công!");
			            listlop.add(lh); // them vao danh sach HP
			            ((DefaultTableModel) tbLH.getModel()).addRow(new Object[] {
			            		j++, lh.getMalop(), lh.getMahp(), lh.getTenhp(), lh.getTinchi(), lh.getTiet(), lh.getThu(), lh.getPhonghoc()});
			        } else{
			            JOptionPane.showMessageDialog(rootPane, "Mã lớp đã tồn tại!");
			        }
				}
			}
		});
		
		// eventXoalop
		btXoalop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tfMaLop.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane, "Không tồn tại Mã Lớp!");
				}
				else {
					if (new LopHocDAO().deleteLopHoc(tfMaLop.getText())) {
						JOptionPane.showMessageDialog(rootPane, "Xóa thành công!");
						listSubject();
						ResetTable();
						ShowTable();
					}
					else JOptionPane.showMessageDialog(rootPane, "Không tồn tại!");
				}
			}
		});
		
		//eventSearchLH
		btSearchLH.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int count = 1;
				searchlh =new LopHocDAO().searchListLH(tfMaLop.getText(), tfTenHP.getText(), tfMaHP.getText());
				((DefaultTableModel) tbLH.getModel()).setRowCount(0);
				
				for (LopHoc lh: searchlh) {
					((DefaultTableModel) tbLH.getModel()).addRow(new Object[] {
							count++, lh.getMalop(), lh.getMahp(), lh.getTenhp(), lh.getTinchi(), lh.getTiet(), lh.getThu(), lh.getPhonghoc()});
				}
			}
		});
		
		// event ThemDK
		btThemDK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tfMssvDK.getText().equals("") && tfMaLopDK.getText().equals(""))
					JOptionPane.showMessageDialog(rootPane, "Không được để trống MSSV và Mã lớp!");
				else if (!(new DangKyDAO().checkDangKy(tfMssvDK.getText(), tfMaLopDK.getText(), listdk)))
					JOptionPane.showMessageDialog(rootPane, "Đã tồn tại ĐK này!");
				else {
					if (new DangKyDAO().addDangKy(tfMssvDK.getText(), tfMaLopDK.getText())) {
						JOptionPane.showMessageDialog(rootPane, "Thêm thành công!");
						DangKy dk = new DangKyDAO().getDK(tfMssvDK.getText(), tfMaLopDK.getText());
						listdk.add(dk);
						((DefaultTableModel) tbDK.getModel()).addRow(new Object[] {
								k++, dk.getMssv(), dk.getTensv(), dk.getMalop(), dk.getMahp(), dk.getTenhp(), dk.getTin(), dk.getTiet(), dk.getThu(), dk.getPhonghoc()});
					}
					else JOptionPane.showMessageDialog(rootPane, "Không có MSSV hoặc Không có Mã lớp");
				}
			}
		});
		
		//event XoaDK
		btXoaDK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tfMssvDK.getText().equals("") && tfMaLopDK.getText().equals(""))
					JOptionPane.showMessageDialog(rootPane, "Không được để trống MSSV và Mã lớp!");
				else {
					if (new DangKyDAO().deleteDangKy(tfMssvDK.getText(), tfMaLopDK.getText())) {
						JOptionPane.showMessageDialog(rootPane, "Xóa thành công!");
						listSubject();
						ResetTable();
						ShowTable();
					}
					else JOptionPane.showMessageDialog(rootPane, "Không tồn tại!");
				}
			}
		});
		
		//event SearchDK
		btSearchDK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int count = 1;
				searchdk = new DangKyDAO().searchListDK(tfMssvDK.getText(), tfMaLopDK.getText());
				((DefaultTableModel) tbDK.getModel()).setRowCount(0);
				for (DangKy dk: searchdk) {
					((DefaultTableModel) tbDK.getModel()).addRow(new Object[] {
							count++, dk.getMssv(), dk.getTensv(), dk.getMalop(), dk.getMahp(), dk.getTenhp(), dk.getTin(), dk.getTiet(), dk.getThu(), dk.getPhonghoc()});
				}
			}
		});
	}
}
