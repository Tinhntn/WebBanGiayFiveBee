
CREATE DATABASE [WebBanGiayFiveBee]
 go
 use [WebBanGiayFiveBee]
 go
CREATE TABLE [dbo].[ChatLieu](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 29/05/2024 4:52:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[Id] [uniqueidentifier] NOT NULL,
	[idHoaDon] [uniqueidentifier] NULL,
	[idChiTietSanPham] [uniqueidentifier] NULL,
	[soLuong] [int] NULL,
	[donGia] [decimal](20, 0) NULL,
	[ngayBan] [date] NULL,
	[ngayTao] [date] NULL,
	[ngaySua] [date] NULL,
	[trangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietSanPham]    Script Date: 29/05/2024 4:52:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietSanPham](
	[Id] [uniqueidentifier] NOT NULL,
	[idSanPham] [uniqueidentifier] NULL,
	[hang] [uniqueidentifier] NULL,
	[Size] [uniqueidentifier] NULL,
	[DanhMuc] [uniqueidentifier] NULL,
	[ChatLieu] [uniqueidentifier] NULL,
	[MauSac] [uniqueidentifier] NULL,
	[idKhuyenMai] [uniqueidentifier] NULL,
	[giaNhap] [decimal](20, 0) NULL,
	[giaBan] [decimal](20, 0) NULL,
	[QR] [int] IDENTITY(20012003,1) NOT NULL,
	[HinhAnh] [nvarchar](max) NULL,
	[SoLuong] [int] NULL,
	[MoTa] [nvarchar](100) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 29/05/2024 4:52:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[id] [uniqueidentifier] NOT NULL,
	[maChucVu] [varchar](20) NULL,
	[tenChucVu] [varchar](20) NULL,
	[ngayTao] [date] NULL,
	[ngaySua] [date] NULL,
	[trangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DanhMuc]    Script Date: 29/05/2024 4:52:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMuc](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GioHang]    Script Date: 29/05/2024 4:52:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GioHang](
	[idGioHang] [uniqueidentifier] NOT NULL,
	[idNhanVien] [uniqueidentifier] NULL,
	[idKhachHang] [uniqueidentifier] NULL,
	[idKhuyenMai] [uniqueidentifier] NULL,
	[maGioHang] [varchar](20)  NULL,
	[ngayMua] [date]  NULL,
	[ngayTao] [date]  NULL,
	[ngaySua] [date]  NULL,
	[trangThai] [int] NULL,
	[ghiChu] [nvarchar](max) NULL,
 CONSTRAINT [pk_idGioHang] PRIMARY KEY CLUSTERED 
(
	[idGioHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GioHangChiTiet]    Script Date: 29/05/2024 4:52:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GioHangChiTiet](
	[idGioHangChiTiet] [uniqueidentifier] NOT NULL,
	[idGioHang] [uniqueidentifier] NULL,
	[idChiTietSanPham] [uniqueidentifier] NULL,
	[soLuong] [int]  NULL,
	[donGia] [float]  NULL,
	[donGiaKhiGiam] [float]  NULL,
	[tongTien] [float] NULL,
	[ngayTao] [date]  NULL,
	[ngaySua] [date]  NULL,
	[trangThai] [int] NULL,
 CONSTRAINT [pk_idGioHangChiTiet] PRIMARY KEY CLUSTERED 
(
	[idGioHangChiTiet] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Hang]    Script Date: 29/05/2024 4:52:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Hang](
	[idHang] [uniqueidentifier] NOT NULL,
	[maHang] [varchar](20) NULL,
	[tenHang] [nvarchar](30) NULL,
	[ngayTao] [date] NULL,
	[ngaySua] [date] NULL,
	[trangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[idHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 29/05/2024 4:52:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[ID] [uniqueidentifier] NOT NULL,
	[maHoaDon] [varchar](20) NULL,
	[idNhanVien] [uniqueidentifier] NULL,
	[idKhachHang] [uniqueidentifier] NULL,
	[ngayMua] [date] NULL,
	[thanhTien] [decimal](20, 0) NULL,
	[idKhuyenMai] [uniqueidentifier] NULL,
	[GhiChu] [nvarchar](100) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[TienKhachDua] [decimal](20, 0) NULL,
	[TongTien] [decimal](20,0) null,
	[TienThua] [decimal](20, 0) NULL,
	[TongTienGiam] [decimal](20, 0) NULL,
	[NgayGiaoHang][date] null,
	[DonViGiao][nvarchar](200) null,
	[PhiShip][decimal](20, 0) null,
	[TenNguoiNhan][nvarchar](200) null,
	[EmailNguoiNhan][nvarchar](200) null,
	[SDTNguoiNhan][nvarchar](200) null,
	[TinhThanh][nvarchar](200) null,
	[QuanHuyen][nvarchar](200) null,
	[PhuongXa][nvarchar](200) null,
	[LoaiHoaDon] [int] null,
	[LoaiThanhToan] [int] null,
	[TenNguoiGiao] [nvarchar](200) null,
	[SDTNguoiGiao] [nvarchar](11) null,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 29/05/2024 4:52:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[ID] [uniqueidentifier] NOT NULL,
	[maKhachHang] [varchar](20) NULL,
	[loaiKhachHang] [nvarchar](50) NULL,
	[tenKhachHang] [nvarchar](50) NULL,
	[diaChi] [nvarchar](200) NULL,
	[gioiTinh] [nvarchar](50) NULL,
	[email] [varchar](50) NULL,
	[sdt] [varchar](50) NULL,
	[ngaySinh] [date] NULL,
	[ngayThamGia] [date] NULL,
	[tichDiem] [int] NULL,
	[diemEXP] [int] NULL,
	[ngayTao] [date] NULL,
	[ngaySua] [date] NULL,
	[MatKhau] [nvarchar](255) null,
	[trangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 29/05/2024 4:52:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[Id] [uniqueidentifier] NOT NULL,
	[maKhuyenMai] [varchar](20) NULL,
	[tenKhuyenMai] [nvarchar](20) NULL,
	[giaTri] [decimal](20, 0) NULL,
	[dieuKienGiam] [decimal](20, 0) NULL,
	[ngayBatDau] [date] NULL,
	[ngayKetThuc] [date] NULL,
	[hinhThucApDung] [bit] NULL,
	[soLuong] [int] NULL,
	[ngayTao] [date] NULL,
	[ngaySua] [date] NULL,
	[trangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 29/05/2024 4:52:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 29/05/2024 4:52:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[Id] [uniqueidentifier] NOT NULL,
	[maNhanVien] [varchar](20) NULL,
	[hoVaTen] [nvarchar](50) NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [nvarchar](25) NULL,
	[diaChi] [nvarchar](200) NULL,
	[sdt] [varchar](10) NULL,
	[email] [varchar](100) NULL,
	[matKhau] [varchar](20) NULL,
	[IDCV] [uniqueidentifier] NULL,
	[Hinh] [nvarchar](max) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 29/05/2024 4:52:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[Id] [uniqueidentifier] NOT NULL,
	[maSanPham] [varchar](20) NULL,
	[tenSanPham] [nvarchar](30) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Size]    Script Date: 29/05/2024 4:52:31 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Size](
	[Id] [uniqueidentifier] NOT NULL,
	[Ma] [varchar](20) NULL,
	[Ten] [nvarchar](30) NULL,
	[NgayTao] [date] NULL,
	[NgaySua] [date] NULL,
	[TrangThai] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
CREATE TABLE lichsutrangthai (
    Id UNIQUEIDENTIFIER NOT NULL PRIMARY KEY,
    idhoadon UNIQUEIDENTIFIER NOT NULL,
    thoigian DATE NULL,
    trangthai INT NULL,
    ghichu NVARCHAR(300) NULL,
    FOREIGN KEY (idhoadon) REFERENCES hoadon(id)
);
INSERT [dbo].[ChatLieu] ( [Ma], [Ten], [NgayTao], [NgaySua], [TrangThai]) VALUES ( N'CL003', N'Nỉ', CAST(N'2024-01-07' AS Date), NULL, 1)
INSERT [dbo].[ChatLieu] ( [Ma], [Ten], [NgayTao], [NgaySua], [TrangThai]) VALUES ( N'CL001', N'Da tổng hợp', CAST(N'2024-01-07' AS Date), CAST(N'2024-01-07' AS Date), 1)
INSERT [dbo].[ChatLieu] ( [Ma], [Ten], [NgayTao], [NgaySua], [TrangThai]) VALUES ( N'CL002', N'Vải', CAST(N'2024-01-07' AS Date), NULL, 1)
GO
INSERT [dbo].[ChiTietHoaDon] ([Id], [idHoaDon], [idChiTietSanPham], [soLuong], [donGia], [ngayBan], [ngayTao], [ngaySua], [trangThai]) VALUES (N'e797b109-eb00-4dec-8741-01fd2b9a4bab', N'a0a0574e-399f-46e4-a6b9-3f9a1618a639', N'a6e3ba39-006e-4e2b-8621-c2870dc64f41', 1, CAST(2000000 AS Decimal(20, 0)), CAST(N'2024-02-24' AS Date), CAST(N'2024-02-24' AS Date), NULL, 1)
INSERT [dbo].[ChiTietHoaDon] ([Id], [idHoaDon], [idChiTietSanPham], [soLuong], [donGia], [ngayBan], [ngayTao], [ngaySua], [trangThai]) VALUES (N'ba8c896d-fd0f-4e43-987d-49d1029d279b', N'a3af09db-00e0-4803-a896-15c5f6567f54', N'a6e3ba39-006e-4e2b-8621-c2870dc64f41', 1, CAST(2000000 AS Decimal(20, 0)), CAST(N'2024-02-26' AS Date), CAST(N'2024-02-26' AS Date), NULL, 1)
INSERT [dbo].[ChiTietHoaDon] ([Id], [idHoaDon], [idChiTietSanPham], [soLuong], [donGia], [ngayBan], [ngayTao], [ngaySua], [trangThai]) VALUES (N'92c15cee-11e7-4621-8a03-7c67064b75db', N'9d3115fd-8a0c-434c-b994-5e5d3e28c3ae', N'a6e3ba39-006e-4e2b-8621-c2870dc64f41', 1, CAST(2000000 AS Decimal(20, 0)), CAST(N'2024-02-25' AS Date), CAST(N'2024-02-25' AS Date), NULL, 1)
INSERT [dbo].[ChiTietHoaDon] ([Id], [idHoaDon], [idChiTietSanPham], [soLuong], [donGia], [ngayBan], [ngayTao], [ngaySua], [trangThai]) VALUES (N'36d3c917-7c93-4af3-aff4-89655ad6d275', N'0c032790-17f3-4edf-b052-cf9ba7f8b0dc', N'0c6306bd-de7e-4a0d-982c-62e47519fd1f', 2, CAST(600000 AS Decimal(20, 0)), CAST(N'2024-02-26' AS Date), CAST(N'2024-02-26' AS Date), NULL, 1)
INSERT [dbo].[ChiTietHoaDon] ([Id], [idHoaDon], [idChiTietSanPham], [soLuong], [donGia], [ngayBan], [ngayTao], [ngaySua], [trangThai]) VALUES (N'09bbc681-8eea-4990-b963-8ea448709ff1', N'c09633e0-2ad1-4a39-a84a-56297e5f730b', N'a6e3ba39-006e-4e2b-8621-c2870dc64f41', 3, CAST(6000000 AS Decimal(20, 0)), CAST(N'2024-02-25' AS Date), CAST(N'2024-02-25' AS Date), NULL, 1)
INSERT [dbo].[ChiTietHoaDon] ([Id], [idHoaDon], [idChiTietSanPham], [soLuong], [donGia], [ngayBan], [ngayTao], [ngaySua], [trangThai]) VALUES (N'c4a9b346-afa1-49db-aba7-a93b5b61602b', N'c731bf63-a311-4899-a586-6d6c4b6c3cf4', N'0c6306bd-de7e-4a0d-982c-62e47519fd1f', 2, CAST(600000 AS Decimal(20, 0)), CAST(N'2024-02-26' AS Date), CAST(N'2024-02-26' AS Date), NULL, 1)
INSERT [dbo].[ChiTietHoaDon] ([Id], [idHoaDon], [idChiTietSanPham], [soLuong], [donGia], [ngayBan], [ngayTao], [ngaySua], [trangThai]) VALUES (N'c0dde4b0-c5b7-4806-909d-b91d2f0237dc', N'6834e020-7b76-4e3f-8201-160d98450162', N'a6e3ba39-006e-4e2b-8621-c2870dc64f41', 1, CAST(2000000 AS Decimal(20, 0)), CAST(N'2024-02-26' AS Date), CAST(N'2024-02-26' AS Date), NULL, 1)
INSERT [dbo].[ChiTietHoaDon] ([Id], [idHoaDon], [idChiTietSanPham], [soLuong], [donGia], [ngayBan], [ngayTao], [ngaySua], [trangThai]) VALUES (N'31083fd7-2f7a-4878-b807-e2b2f0ac3378', N'1c5f508c-c618-4f64-b564-fe74a540c806', N'0c6306bd-de7e-4a0d-982c-62e47519fd1f', 3, CAST(900000 AS Decimal(20, 0)), CAST(N'2024-02-26' AS Date), CAST(N'2024-02-26' AS Date), NULL, 1)
INSERT [dbo].[ChiTietHoaDon] ([Id], [idHoaDon], [idChiTietSanPham], [soLuong], [donGia], [ngayBan], [ngayTao], [ngaySua], [trangThai]) VALUES (N'5fea9867-4080-4f9f-b985-ec2a1a64dc1d', N'6834e020-7b76-4e3f-8201-160d98450162', N'0c6306bd-de7e-4a0d-982c-62e47519fd1f', 3, CAST(900000 AS Decimal(20, 0)), CAST(N'2024-02-26' AS Date), CAST(N'2024-02-26' AS Date), CAST(N'2024-02-26' AS Date), 1)
GO
SET IDENTITY_INSERT [dbo].[ChiTietSanPham] ON 

INSERT [dbo].[ChiTietSanPham] ([Id], [idSanPham], [hang], [Size], [DanhMuc], [ChatLieu], [MauSac], [idKhuyenMai], [giaNhap], [giaBan], [QR], [HinhAnh], [SoLuong], [MoTa], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'0c6306bd-de7e-4a0d-982c-62e47519fd1f', N'9ee83ae6-8f90-4a0a-9a61-5bccd311ed13', N'52f60c18-407e-47ae-aa81-a932b561efb0', N'f673b5e8-1213-4f3f-a400-2af46786a910', N'995b0ae4-d688-45c3-baf4-2473332b6448', N'c2973856-5854-41f4-bebf-b0d7dbacee9f', N'241ee937-f33e-48ac-8429-09ca11a18353', NULL, CAST(100000 AS Decimal(20, 0)), CAST(300000 AS Decimal(20, 0)), 20012007, N'C:\Users\DELL\Desktop\tinh\Fpt_PolytechnicTaiNguyen\Spring2024\Sneaker_FpolyTuyen\Sneaker_FpolyTuyen\src\utility\img\giay1.jpg', 2, N'GIAY NIKE', CAST(N'2024-02-26' AS Date), CAST(N'2024-02-26' AS Date), 1)
INSERT [dbo].[ChiTietSanPham] ([Id], [idSanPham], [hang], [Size], [DanhMuc], [ChatLieu], [MauSac], [idKhuyenMai], [giaNhap], [giaBan], [QR], [HinhAnh], [SoLuong], [MoTa], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'a6e3ba39-006e-4e2b-8621-c2870dc64f41', N'c22c5084-0853-44a9-ac7c-522f4cb535f0', N'3ad0d061-a225-4291-acf7-0381ab00c530', N'f673b5e8-1213-4f3f-a400-2af46786a910', N'995b0ae4-d688-45c3-baf4-2473332b6448', N'3a2a7163-1a08-4d6a-9a67-d81be59cfc30', N'861f5ef2-77ee-485c-8ed7-1c08306176a5', NULL, CAST(100000 AS Decimal(20, 0)), CAST(2000000 AS Decimal(20, 0)), 20012006, N'C:\Users\DELL\Desktop\tinh\Fpt_PolytechnicTaiNguyen\Spring2024\Sneaker_FpolyTuyen\Sneaker_FpolyTuyen\src\utility\img\giay2.jpg', 5, N'giày add', CAST(N'2024-02-24' AS Date), CAST(N'2024-02-26' AS Date), 1)
SET IDENTITY_INSERT [dbo].[ChiTietSanPham] OFF
GO
INSERT [dbo].[ChucVu] ([id], [maChucVu], [tenChucVu], [ngayTao], [ngaySua], [trangThai]) VALUES (N'b2396cbc-80d1-4776-89dc-284a043234af', N'CV001', N'Qu?n lý', CAST(N'2024-01-07' AS Date), CAST(N'2024-01-07' AS Date), 1)
INSERT [dbo].[ChucVu] ([id], [maChucVu], [tenChucVu], [ngayTao], [ngaySua], [trangThai]) VALUES (N'e8cf3ae7-e37c-4356-84f1-c50b1473dea2', N'CV002', N'Nhân viên bán hàng', CAST(N'2024-01-07' AS Date), NULL, 1)
GO
INSERT [dbo].[DanhMuc] ( [Ma], [Ten], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'DM001', N'Giày nam', CAST(N'2024-01-07' AS Date), CAST(N'2024-01-07' AS Date), 1)
INSERT [dbo].[DanhMuc] ( [Ma], [Ten], [NgayTao], [NgaySua], [TrangThai]) VALUES ( N'DM002', N'Giày nữ', CAST(N'2024-01-07' AS Date), NULL, 1)
GO
INSERT [dbo].[Hang] ( [maHang], [tenHang], [ngayTao], [ngaySua], [trangThai]) VALUES ( N'HANG001', N'Adidas', CAST(N'2024-01-07' AS Date), CAST(N'2024-01-07' AS Date), 1)
INSERT [dbo].[Hang] ( [maHang], [tenHang], [ngayTao], [ngaySua], [trangThai]) VALUES ( N'HANG002', N'Nike', CAST(N'2024-01-07' AS Date), NULL, 1)
INSERT [dbo].[Hang] ( [maHang], [tenHang], [ngayTao], [ngaySua], [trangThai]) VALUES ( N'HANG003', N'Puma', CAST(N'2024-01-07' AS Date), NULL, 1)
GO
INSERT [dbo].[HoaDon] ([ID], [maHoaDon], [idNhanVien], [idKhachHang], [ngayMua], [thanhTien], [idKhuyenMai], [GhiChu], [NgayTao], [NgaySua], [TienKhachDua], [TienThua], [TongTienGiam], [TrangThai]) VALUES (N'a3af09db-00e0-4803-a896-15c5f6567f54', N'HD40102', N'99dd1ffc-2e78-49bc-9bcc-3b04fadf3a2b', N'ecd99295-69d7-4cd1-858b-12e87e52fbca', CAST(N'2023-01-26' AS Date), CAST(1600000 AS Decimal(20, 0)), N'686145f4-a63f-4fbf-a4bf-5e88664e4c7f', N'thanh toán đủ', CAST(N'2023-01-26' AS Date), NULL, CAST(3000000 AS Decimal(20, 0)), CAST(1000000 AS Decimal(20, 0)), CAST(400000 AS Decimal(20, 0)), 1)
INSERT [dbo].[HoaDon] ([ID], [maHoaDon], [idNhanVien], [idKhachHang], [ngayMua], [thanhTien], [idKhuyenMai], [GhiChu], [NgayTao], [NgaySua], [TienKhachDua], [TienThua], [TongTienGiam], [TrangThai]) VALUES (N'6834e020-7b76-4e3f-8201-160d98450162', N'HD97737', N'99dd1ffc-2e78-49bc-9bcc-3b04fadf3a2b', N'a25b6f1e-1ce3-4f95-9e25-e538b7352684', CAST(N'2023-01-26' AS Date), CAST(2320000 AS Decimal(20, 0)), N'686145f4-a63f-4fbf-a4bf-5e88664e4c7f', N'thanh toán đủ', CAST(N'2023-01-26' AS Date), NULL, CAST(3000000 AS Decimal(20, 0)), CAST(100000 AS Decimal(20, 0)), CAST(580000 AS Decimal(20, 0)), 1)
INSERT [dbo].[HoaDon] ([ID], [maHoaDon], [idNhanVien], [idKhachHang], [ngayMua], [thanhTien], [idKhuyenMai], [GhiChu], [NgayTao], [NgaySua], [TienKhachDua], [TienThua], [TongTienGiam], [TrangThai]) VALUES (N'a0a0574e-399f-46e4-a6b9-3f9a1618a639', N'HD57477', N'99dd1ffc-2e78-49bc-9bcc-3b04fadf3a2b', N'7c6ac49d-21bc-4d6d-89ea-00d85bba9dc6', CAST(N'2022-03-24' AS Date), CAST(1600000 AS Decimal(20, 0)), N'686145f4-a63f-4fbf-a4bf-5e88664e4c7f', N'thanh toán đủ', CAST(N'2022-03-24' AS Date), NULL, CAST(10000000 AS Decimal(20, 0)), CAST(8000000 AS Decimal(20, 0)), CAST(400000 AS Decimal(20, 0)), 1)
INSERT [dbo].[HoaDon] ([ID], [maHoaDon], [idNhanVien], [idKhachHang], [ngayMua], [thanhTien], [idKhuyenMai], [GhiChu], [NgayTao], [NgaySua], [TienKhachDua], [TienThua], [TongTienGiam], [TrangThai]) VALUES (N'c09633e0-2ad1-4a39-a84a-56297e5f730b', N'HD19704', N'99dd1ffc-2e78-49bc-9bcc-3b04fadf3a2b', N'ecd99295-69d7-4cd1-858b-12e87e52fbca', CAST(N'2021-05-25' AS Date), CAST(4800000 AS Decimal(20, 0)), N'686145f4-a63f-4fbf-a4bf-5e88664e4c7f', N'thanh toán đủ', CAST(N'2021-05-25' AS Date), NULL, CAST(20000000 AS Decimal(20, 0)), CAST(14000000 AS Decimal(20, 0)), CAST(1200000 AS Decimal(20, 0)), 1)
INSERT [dbo].[HoaDon] ([ID], [maHoaDon], [idNhanVien], [idKhachHang], [ngayMua], [thanhTien], [idKhuyenMai], [GhiChu], [NgayTao], [NgaySua], [TienKhachDua], [TienThua], [TongTienGiam], [TrangThai]) VALUES (N'9d3115fd-8a0c-434c-b994-5e5d3e28c3ae', N'HD39414', N'99dd1ffc-2e78-49bc-9bcc-3b04fadf3a2b', N'ecd99295-69d7-4cd1-858b-12e87e52fbca', CAST(N'2020-02-25' AS Date), CAST(2000000 AS Decimal(20, 0)), N'686145f4-a63f-4fbf-a4bf-5e88664e4c7f', N'thanh toán đủ', CAST(N'2020-02-25' AS Date), NULL, CAST(3000000 AS Decimal(20, 0)), CAST(1000000 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), 1)
INSERT [dbo].[HoaDon] ([ID], [maHoaDon], [idNhanVien], [idKhachHang], [ngayMua], [thanhTien], [idKhuyenMai], [GhiChu], [NgayTao], [NgaySua], [TienKhachDua], [TienThua], [TongTienGiam], [TrangThai]) VALUES (N'c731bf63-a311-4899-a586-6d6c4b6c3cf4', N'HD38438', N'99dd1ffc-2e78-49bc-9bcc-3b04fadf3a2b', N'ecd99295-69d7-4cd1-858b-12e87e52fbca', CAST(N'2020-02-25' AS Date), CAST(480000 AS Decimal(20, 0)), N'686145f4-a63f-4fbf-a4bf-5e88664e4c7f', N'thanh toán đủ', CAST(N'2020-02-25' AS Date), NULL, CAST(1000000 AS Decimal(20, 0)), CAST(400000 AS Decimal(20, 0)), CAST(120000 AS Decimal(20, 0)), 1)
INSERT [dbo].[HoaDon] ([ID], [maHoaDon], [idNhanVien], [idKhachHang], [ngayMua], [thanhTien], [idKhuyenMai], [GhiChu], [NgayTao], [NgaySua], [TienKhachDua], [TienThua], [TongTienGiam], [TrangThai]) VALUES (N'0c032790-17f3-4edf-b052-cf9ba7f8b0dc', N'HD16078', N'99dd1ffc-2e78-49bc-9bcc-3b04fadf3a2b', N'ecd99295-69d7-4cd1-858b-12e87e52fbca', CAST(N'2024-02-26' AS Date), CAST(480000 AS Decimal(20, 0)), N'686145f4-a63f-4fbf-a4bf-5e88664e4c7f', N'thanh toán đủ', CAST(N'2024-02-26' AS Date), NULL, CAST(0 AS Decimal(20, 0)), CAST(0 AS Decimal(20, 0)), CAST(120000 AS Decimal(20, 0)), 1)
INSERT [dbo].[HoaDon] ([ID], [maHoaDon], [idNhanVien], [idKhachHang], [ngayMua], [thanhTien], [idKhuyenMai], [GhiChu], [NgayTao], [NgaySua], [TienKhachDua], [TienThua], [TongTienGiam], [TrangThai]) VALUES (N'1c5f508c-c618-4f64-b564-fe74a540c806', N'HD16518', N'99dd1ffc-2e78-49bc-9bcc-3b04fadf3a2b', NULL, CAST(N'2024-02-26' AS Date), CAST(720000 AS Decimal(20, 0)), N'686145f4-a63f-4fbf-a4bf-5e88664e4c7f', N'Nullthanh toán đủ', CAST(N'2024-02-26' AS Date), NULL, CAST(1000000 AS Decimal(20, 0)), CAST(100000 AS Decimal(20, 0)), CAST(180000 AS Decimal(20, 0)), 1)
GO
INSERT [dbo].[KhachHang] ([ID], [maKhachHang], [loaiKhachHang], [tenKhachHang], [diaChi], [gioiTinh], [email], [sdt], [ngaySinh], [ngayThamGia], [tichDiem], [diemEXP], [ngayTao], [ngaySua], [trangThai]) VALUES (N'7c6ac49d-21bc-4d6d-89ea-00d85bba9dc6', N'KH001', N'Thân thi?t', N'Nguyễn Thị Dung', N'HaNoi', N'Nữ', N'ntd@example.com', N'0369852147', CAST(N'1992-03-15' AS Date), CAST(N'2023-01-07' AS Date), 100, 50, CAST(N'2024-01-07' AS Date), CAST(N'2024-01-07' AS Date), 1)
INSERT [dbo].[KhachHang] ([ID], [maKhachHang], [loaiKhachHang], [tenKhachHang], [diaChi], [gioiTinh], [email], [sdt], [ngaySinh], [ngayThamGia], [tichDiem], [diemEXP], [ngayTao], [ngaySua], [trangThai]) VALUES (N'ecd99295-69d7-4cd1-858b-12e87e52fbca', N'KH003', N'Thu?ng', N'Trần Thị Phương', N'HaNoi', N'Nữ', N'tft@example.com', N'0123456789', CAST(N'1998-12-05' AS Date), CAST(N'2021-01-07' AS Date), 20, 10, CAST(N'2024-01-07' AS Date), CAST(N'2024-01-07' AS Date), 1)
INSERT [dbo].[KhachHang] ([ID], [maKhachHang], [loaiKhachHang], [tenKhachHang], [diaChi], [gioiTinh], [email], [sdt], [ngaySinh], [ngayThamGia], [tichDiem], [diemEXP], [ngayTao], [ngaySua], [trangThai]) VALUES (N'a25b6f1e-1ce3-4f95-9e25-e538b7352684', N'KH002', N'VIP', N'Lê Văn Em', N'HaNoi', N'Nam', N'lve@example.com', N'0987654321', CAST(N'1985-08-22' AS Date), CAST(N'2022-01-07' AS Date), 500, 200, CAST(N'2024-01-07' AS Date), CAST(N'2024-01-07' AS Date), 1)
GO
INSERT [dbo].[KhuyenMai] ([Id], [maKhuyenMai], [tenKhuyenMai], [giaTri], [dieuKienGiam], [ngayBatDau], [ngayKetThuc], [hinhThucApDung], [soLuong], [ngayTao], [ngaySua], [trangThai]) VALUES (N'686145f4-a63f-4fbf-a4bf-5e88664e4c7f', N'KM1', N'Giảm giá cuối năm', CAST(20 AS Decimal(20, 0)), CAST(100000 AS Decimal(20, 0)), CAST(N'2024-02-23' AS Date), CAST(N'2024-02-29' AS Date), 1, 12, NULL, NULL, 1)
GO
INSERT [dbo].[MauSac] ( [Ma], [Ten], [NgayTao], [NgaySua], [TrangThai]) VALUES ( N'MS001', N'Đen', CAST(N'2024-01-07' AS Date), CAST(N'2024-01-07' AS Date), 1)
INSERT [dbo].[MauSac] ( [Ma], [Ten], [NgayTao], [NgaySua], [TrangThai]) VALUES ( N'MS002', N'Trắng', CAST(N'2024-01-07' AS Date), NULL, 1)
INSERT [dbo].[MauSac] ( [Ma], [Ten], [NgayTao], [NgaySua], [TrangThai]) VALUES ( N'MS003', N'Đỏ', CAST(N'2024-01-07' AS Date), NULL, 1)
GO
INSERT [dbo].[NhanVien] ( [maNhanVien], [hoVaTen], [ngaySinh], [gioiTinh], [diaChi], [sdt], [email], [matKhau], [IDCV], [Hinh], [NgayTao], [NgaySua], [TrangThai]) VALUES ( N'NV002', N'Trần Thị Binh', CAST(N'2003-05-15' AS Date), N'Nữ', N'Nam Tu Liem Ha Noi', N'0987654321', N'ttb@example.com', N'123', N'e8cf3ae7-e37c-4356-84f1-c50b1473dea2', N'avatar2.jpg', CAST(N'2024-01-07' AS Date), CAST(N'2024-01-07' AS Date), 1)
INSERT [dbo].[NhanVien] ( [maNhanVien], [hoVaTen], [ngaySinh], [gioiTinh], [diaChi], [sdt], [email], [matKhau], [IDCV], [Hinh], [NgayTao], [NgaySua], [TrangThai]) VALUES ( N'NV001', N'Nguyễn Văn Quang', CAST(N'2002-01-01' AS Date), N'Nam', N'Phu an, TP.Thanh Hoa', N'0123456789', N'nva@example.com', N'123', N'b2396cbc-80d1-4776-89dc-284a043234af', N'avatar1.jpg', CAST(N'2024-01-07' AS Date), CAST(N'2024-01-07' AS Date), 1)
INSERT [dbo].[NhanVien] ( [maNhanVien], [hoVaTen], [ngaySinh], [gioiTinh], [diaChi], [sdt], [email], [matKhau], [IDCV], [Hinh], [NgayTao], [NgaySua], [TrangThai]) VALUES ( N'NV003', N'Lê Văn Nam', CAST(N'1999-08-08' AS Date), N'Nam', N'Cau Giay Ha Noi', N'0369852147', N'tinhnvph28538@fpt.edu.vn', N'DYs9Pe', N'b2396cbc-80d1-4776-89dc-284a043234af', N'avatar3.jpg', CAST(N'2024-01-07' AS Date), CAST(N'2024-01-07' AS Date), 1)
GO
INSERT [dbo].[SanPham] ([Id], [maSanPham], [tenSanPham], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'c22c5084-0853-44a9-ac7c-522f4cb535f0', N'SP003', N'Ph? ki?n 003', CAST(N'2024-01-07' AS Date), NULL, 1)
INSERT [dbo].[SanPham] ([Id], [maSanPham], [tenSanPham], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'9ee83ae6-8f90-4a0a-9a61-5bccd311ed13', N'SP001', N'Sneaker Nam 001', CAST(N'2024-01-07' AS Date), CAST(N'2024-01-07' AS Date), 1)
INSERT [dbo].[SanPham] ([Id], [maSanPham], [tenSanPham], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'ccebf638-0a02-443e-ac61-9cd3cee6db60', N'SP002', N'Sneaker N? 002', CAST(N'2024-01-07' AS Date), NULL, 1)
GO
INSERT [dbo].[Size] ( [Ma], [Ten], [NgayTao], [NgaySua], [TrangThai]) VALUES ( N'SIZE001', N'39', CAST(N'2024-01-07' AS Date), CAST(N'2024-01-07' AS Date), 1)
INSERT [dbo].[Size] ( [Ma], [Ten], [NgayTao], [NgaySua], [TrangThai]) VALUES (N'SIZE003', N'41', CAST(N'2024-01-07' AS Date), NULL, 1)
INSERT [dbo].[Size] ( [Ma], [Ten], [NgayTao], [NgaySua], [TrangThai]) VALUES ( N'SIZE002', N'40', CAST(N'2024-01-07' AS Date), NULL, 1)
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__ChatLieu__3214CC9EC9CF756D]    Script Date: 29/05/2024 4:52:31 CH ******/
ALTER TABLE [dbo].[ChatLieu] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__ChucVu__6E42BCD84F3B9CF7]    Script Date: 29/05/2024 4:52:31 CH ******/
ALTER TABLE [dbo].[ChucVu] ADD UNIQUE NONCLUSTERED 
(
	[maChucVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__DanhMuc__3214CC9EE4905D4B]    Script Date: 29/05/2024 4:52:31 CH ******/
ALTER TABLE [dbo].[DanhMuc] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__hang__C28CA330405AD90E]    Script Date: 29/05/2024 4:52:31 CH ******/
ALTER TABLE [dbo].[Hang] ADD UNIQUE NONCLUSTERED 
(
	[maHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__HoaDon__026B4D9B4B2E7CCB]    Script Date: 29/05/2024 4:52:31 CH ******/
ALTER TABLE [dbo].[HoaDon] ADD UNIQUE NONCLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__KhachHan__0CCB3D4833C29739]    Script Date: 29/05/2024 4:52:31 CH ******/
ALTER TABLE [dbo].[KhachHang] ADD UNIQUE NONCLUSTERED 
(
	[maKhachHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__KhuyenMa__87BEDDE8A78F9EC7]    Script Date: 29/05/2024 4:52:31 CH ******/
ALTER TABLE [dbo].[KhuyenMai] ADD UNIQUE NONCLUSTERED 
(
	[maKhuyenMai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__MauSac__3214CC9E196E40DC]    Script Date: 29/05/2024 4:52:31 CH ******/
ALTER TABLE [dbo].[MauSac] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__NhanVien__BDDEF20CF91035E6]    Script Date: 29/05/2024 4:52:31 CH ******/
ALTER TABLE [dbo].[NhanVien] ADD UNIQUE NONCLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__SanPham__5B439C42B09227B9]    Script Date: 29/05/2024 4:52:31 CH ******/
ALTER TABLE [dbo].[SanPham] ADD UNIQUE NONCLUSTERED 
(
	[maSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Size__3214CC9E401FB95F]    Script Date: 29/05/2024 4:52:31 CH ******/
ALTER TABLE [dbo].[Size] ADD UNIQUE NONCLUSTERED 
(
	[Ma] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChatLieu] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[ChatLieu] ADD  DEFAULT (NULL) FOR [NgayTao]
GO
ALTER TABLE [dbo].[ChatLieu] ADD  DEFAULT (NULL) FOR [NgaySua]
GO
ALTER TABLE [dbo].[ChatLieu] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[ChiTietHoaDon] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[ChiTietHoaDon] ADD  DEFAULT (NULL) FOR [soLuong]
GO
ALTER TABLE [dbo].[ChiTietHoaDon] ADD  DEFAULT ((0)) FOR [donGia]
GO
ALTER TABLE [dbo].[ChiTietHoaDon] ADD  DEFAULT (NULL) FOR [ngayBan]
GO
ALTER TABLE [dbo].[ChiTietHoaDon] ADD  DEFAULT (NULL) FOR [ngayTao]
GO
ALTER TABLE [dbo].[ChiTietHoaDon] ADD  DEFAULT (NULL) FOR [ngaySua]
GO
ALTER TABLE [dbo].[ChiTietHoaDon] ADD  DEFAULT ((0)) FOR [trangThai]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  DEFAULT ((0)) FOR [giaNhap]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  DEFAULT ((0)) FOR [giaBan]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  DEFAULT (NULL) FOR [NgayTao]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  DEFAULT (NULL) FOR [NgaySua]
GO
ALTER TABLE [dbo].[ChiTietSanPham] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[ChucVu] ADD  DEFAULT (newid()) FOR [id]
GO
ALTER TABLE [dbo].[ChucVu] ADD  DEFAULT (NULL) FOR [tenChucVu]
GO
ALTER TABLE [dbo].[ChucVu] ADD  DEFAULT (NULL) FOR [ngayTao]
GO
ALTER TABLE [dbo].[ChucVu] ADD  DEFAULT (NULL) FOR [ngaySua]
GO
ALTER TABLE [dbo].[ChucVu] ADD  DEFAULT ((0)) FOR [trangThai]
GO
ALTER TABLE [dbo].[DanhMuc] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[DanhMuc] ADD  DEFAULT (NULL) FOR [NgayTao]
GO
ALTER TABLE [dbo].[DanhMuc] ADD  DEFAULT (NULL) FOR [NgaySua]
GO
ALTER TABLE [dbo].[DanhMuc] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[Hang] ADD  DEFAULT (newid()) FOR [idHang]
GO
ALTER TABLE [dbo].[Hang] ADD  DEFAULT (NULL) FOR [ngayTao]
GO
ALTER TABLE [dbo].[Hang] ADD  DEFAULT (NULL) FOR [ngaySua]
GO
ALTER TABLE [dbo].[Hang] ADD  DEFAULT ((0)) FOR [trangThai]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (newid()) FOR [ID]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [ngayMua]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [thanhTien]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [GhiChu]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [NgayTao]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (NULL) FOR [NgaySua]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [TienKhachDua]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [TienThua]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [TongTienGiam]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (newid()) FOR [ID]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [loaiKhachHang]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [tenKhachHang]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [diaChi]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [gioiTinh]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [email]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [sdt]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [ngaySinh]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [ngayThamGia]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT ((0)) FOR [tichDiem]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT ((0)) FOR [diemEXP]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [ngayTao]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT (NULL) FOR [ngaySua]
GO
ALTER TABLE [dbo].[KhachHang] ADD  DEFAULT ((0)) FOR [trangThai]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT ((0)) FOR [giaTri]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT ((0)) FOR [dieuKienGiam]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT (NULL) FOR [ngayBatDau]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT (NULL) FOR [ngayKetThuc]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT (NULL) FOR [ngayTao]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT (NULL) FOR [ngaySua]
GO
ALTER TABLE [dbo].[KhuyenMai] ADD  DEFAULT ((0)) FOR [trangThai]
GO
ALTER TABLE [dbo].[MauSac] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[MauSac] ADD  DEFAULT (NULL) FOR [NgayTao]
GO
ALTER TABLE [dbo].[MauSac] ADD  DEFAULT (NULL) FOR [NgaySua]
GO
ALTER TABLE [dbo].[MauSac] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [hoVaTen]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [ngaySinh]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [gioiTinh]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [diaChi]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [sdt]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [email]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [NgayTao]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT (NULL) FOR [NgaySua]
GO
ALTER TABLE [dbo].[NhanVien] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT (NULL) FOR [NgayTao]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT (NULL) FOR [NgaySua]
GO
ALTER TABLE [dbo].[SanPham] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[Size] ADD  DEFAULT (newid()) FOR [Id]
GO
ALTER TABLE [dbo].[Size] ADD  DEFAULT (NULL) FOR [NgayTao]
GO
ALTER TABLE [dbo].[Size] ADD  DEFAULT (NULL) FOR [NgaySua]
GO
ALTER TABLE [dbo].[Size] ADD  DEFAULT ((0)) FOR [TrangThai]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([idHoaDon])
REFERENCES [dbo].[HoaDon] ([ID])
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([idHoaDon])
REFERENCES [dbo].[HoaDon] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([ChatLieu])
REFERENCES [dbo].[ChatLieu] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([DanhMuc])
REFERENCES [dbo].[DanhMuc] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([idKhuyenMai])
REFERENCES [dbo].[KhuyenMai] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([idSanPham])
REFERENCES [dbo].[SanPham] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([MauSac])
REFERENCES [dbo].[MauSac] ([Id])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([hang])
REFERENCES [dbo].[Hang] ([idHang])
GO
ALTER TABLE [dbo].[ChiTietSanPham]  WITH CHECK ADD FOREIGN KEY([Size])
REFERENCES [dbo].[Size] ([Id])
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD  CONSTRAINT [idKhachHang] FOREIGN KEY([idKhachHang])
REFERENCES [dbo].[KhachHang] ([ID])
GO
ALTER TABLE [dbo].[GioHang] CHECK CONSTRAINT [idKhachHang]
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD  CONSTRAINT [idKhuyenMai] FOREIGN KEY([idKhuyenMai])
REFERENCES [dbo].[KhuyenMai] ([Id])
GO
ALTER TABLE [dbo].[GioHang] CHECK CONSTRAINT [idKhuyenMai]
GO
ALTER TABLE [dbo].[GioHang]  WITH CHECK ADD  CONSTRAINT [idNhanVien] FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[NhanVien] ([Id])
GO
ALTER TABLE [dbo].[GioHang] CHECK CONSTRAINT [idNhanVien]
GO
ALTER TABLE [dbo].[GioHangChiTiet]  WITH CHECK ADD  CONSTRAINT [idChiTietSanPham] FOREIGN KEY([idChiTietSanPham])
REFERENCES [dbo].[ChiTietSanPham] ([Id])
GO
ALTER TABLE [dbo].[GioHangChiTiet] CHECK CONSTRAINT [idChiTietSanPham]
GO
ALTER TABLE [dbo].[GioHangChiTiet]  WITH CHECK ADD  CONSTRAINT [idGioHang] FOREIGN KEY([idGioHang])
REFERENCES [dbo].[GioHang] ([idGioHang])
GO
ALTER TABLE [dbo].[GioHangChiTiet] CHECK CONSTRAINT [idGioHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([idKhachHang])
REFERENCES [dbo].[KhachHang] ([ID])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([idKhuyenMai])
REFERENCES [dbo].[KhuyenMai] ([Id])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([idNhanVien])
REFERENCES [dbo].[NhanVien] ([Id])
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD FOREIGN KEY([IDCV])
REFERENCES [dbo].[ChucVu] ([id])
GO
USE [master]
GO
