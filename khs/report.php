<?php
	include("config.php");
	require('fpdf17/fpdf.php');
	//http://localhost/service_khs/report.php?kelas=5&id=1
	//http://www.hakkoblogs.com/2015/06/cara-membuat-laporan-pdf-di-php-dan28.html#.WF5iA1N97IU
	$idKelas = $_GET['kelas'];
	$idMahasiswa = $_GET['id'];
	
	//Cek Nama Kelas dan Semesternya
	$sql = "SELECT * FROM tb_kelas WHERE recid = '$idKelas'";
    $result = mysqli_query($db,$sql);
    $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
    $namaKelas = $row['nama'];
    $semesterKelas = $row['semester'];
    //CEK SKS
    $sql = "SELECT * FROM tb_matkul WHERE recid = '$id_matkul'";
    $result = mysqli_query($db,$sql);
    $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
    $sks = $row['sks'];

    //Cek Nama Mahasiwa dan NIP nya
    $sql = "SELECT * FROM tb_mahasiswa WHERE recid = '$idMahasiswa'";
    $result = mysqli_query($db,$sql);
    $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
    $namaMahasiswa = $row['nama'];
    $nimMahasiswa = $row['nim'];

    //Cek Data Nilai
    $column_matkul = "";
	$column_absen = "";
	$column_tugas = "";
	$column_uts = "";
	$column_uas = "";
	$column_total = "";
	$column_range = "";
	$column_bobot = "";
	$column_sks = "";
	$column_jumlah_sks = "";
	$column_ips = "";
	$column_jumlah_matkul = "";
	$jumlah_matakuliah = "SELECT recid FROM tb_matkul group by recid having count(recid)";
    $sql = "SELECT *,b.nama AS namaMatkul  FROM tb_kelas_mahasiswa a, tb_matkul b, WHERE id_mahasiswa = '$idMahasiswa' AND id_kelas = '$idKelas' AND b.recid = a.id_matkul ";
    if ($result=mysqli_query($db,$sql)){
        while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
            // $listIsi = array();
            // $listIsi['nama'] = $row['nama'];
            // $listIsi['semester'] = $row['semester'];
            // $listIsi['kategori'] = $row['kategori'];
            // $listIsi['recid'] = $row['recid'];
            // $response[] = $listIsi;
            // echo $row['namaMatkul']." - ".$row['nilai_absen']." - ".$row['nilai_tugas']." - ".$row['nilai_uts']." - ".$row['nilai_uas']." - ".$row['range_nilai'];
            // echo "<br>";
            $matkul = $row['namaMatkul'];
            $absen = $row['nilai_absen'];
            $tugas = $row['nilai_tugas'];
            $uts = $row['nilai_uts'];
            $uas = $row['nilai_uas'];
            $nilai = $row['range_nilai'];
            $bobot = $row['bobot'];
            $sks = $row['sks'];
            $jumlah_sks = $row['sks'];
            

            $nilai_absen_percent = $absen * 10 / 100;
            $nilai_tugas_percent = $tugas * 20 / 100;
            $nilai_uts_percent = $uts * 30 / 100;
            $nilai_uas_percent = $uas * 40 / 100;
            $total_nilai = $nilai_absen_percent + $nilai_tugas_percent + $nilai_uts_percent + $nilai_uas_percent;



            $column_matkul = $column_matkul.$matkul."\n";
            $column_sks = $column_sks.$sks."\n";
			$column_absen = $column_absen.$absen."\n";
			$column_tugas = $column_tugas.$tugas."\n";
			$column_uts = $column_uts.$uts."\n";
			$column_uas = $column_uas.$uas."\n";
			$column_total = $column_total.$total_nilai."\n";
			$column_range = $column_range.$nilai."\n";
			$column_bobot = $column_bobot.$bobot."\n";
			$column_jumlah_matkul = $column_jumlah_matkul.$jumlah_matakuliah."\n"
			//$column_ips = $column_ips.$ips."\n";
			//Create a new PDF file
			$pdf = new FPDF('P','mm',array(210,297)); //L For Landscape / P For Portrait
			$pdf->AddPage();

			//Menambahkan Gambar
			$pdf->Image('foto/ic_logo (Custom).png',10,10,-175);

			$pdf->SetFont('Arial','B',13);
			$pdf->Cell(50);
			$pdf->Cell(100,10,'KARTU HASIL STUDI',0,0,'C');
			$pdf->Ln();
			$pdf->Cell(50);
			$pdf->Cell(100,10,'SEKOLAH TINGGI MANAJEMEN INFORMATIKA DAN KOMPUTER',0,0,'C');
			$pdf->Ln();
			$pdf->Cell(50);
			$pdf->Cell(100,10,'MUHAMMADIYAH JAKARTA',0,0,'C');
			$pdf->Ln();
			$pdf->Cell(50);
			$pdf->Cell(100,10,'JL. Kelapa Dua Wetan No. 17 Ciracas Jakarta Timur Telp.021-87717489, 021-87717490',0,0,'C');
			$pdf->Ln();
			$pdf->Cell(50);
			$pdf->Cell(100,10,'http://www.stmikmj.ac.id - Email: stmikmj.ac.id',0,0,'C');
			$pdf->Ln();
			$pdf->Cell(50);
			$pdf->Cell(100,10,$namaMahasiswa.' ('.$nimMahasiswa.')',0,0,'C');
			$pdf->Ln();
			$pdf->Cell(50);
			$pdf->Cell(100,10,$namaKelas.' ( Semester '.$semesterKelas.' )',0,0,'C');
			$pdf->Ln();
        }
        mysqli_free_result($result);
    }

    
    //Fields Name position
	$Y_Fields_Name_position = 60;

	//First create each Field Name
	//Gray color filling each Field Name box
	$pdf->SetFillColor(110,180,230);
	//Bold Font for Field Name
	$pdf->SetFont('Arial','B',10);
	$pdf->SetY($Y_Fields_Name_position);
	$pdf->SetX(5);
	$pdf->Cell(50,8,'MATA KULIAH',1,0,'C',1);
	$pdf->SetX(55);
	$pdf->Cell(25,8,'NILAI ABSEN',1,0,'C',1);
	$pdf->SetX(80);
	$pdf->Cell(25,8,'NILAI TUGAS',1,0,'C',1);
	$pdf->SetX(105);
	$pdf->Cell(25,8,'NILAI UAS',1,0,'C',1);
	$pdf->SetX(130);
	$pdf->Cell(25,8,'NILAI UAS',1,0,'C',1);
	$pdf->SetX(155);
	$pdf->Cell(25,8,'TOTAL',1,0,'C',1);
	$pdf->SetX(180);
	$pdf->Cell(25,8,'HURUF',1,0,'C',1);
	$pdf->Ln();
	$pdf->SetFont('Arial','B',10);
	$pdf->SetX($X_Fields_Name_position);
	$pdf->SetY(5);
	$pdf->Cell(50,8,'JUMLAH SKS',1,0,'C',1);
	$pdf->SetY(55);
	$pdf->Cell(25,8,'JUMLAH MATAKULIAH',1,0,'C',1);
	$pdf->SetY(55);
	$pdf->Cell(25,8,'IPS',1,0,'C',1);
	//Table position, under Fields Name
	$Y_Table_Position = 68;
	
	//Now show the columns
	$pdf->SetFont('Arial','',10);

	$pdf->SetY($Y_Table_Position);
	$pdf->SetX(5);
	$pdf->MultiCell(50,6,$column_matkul,1,'C');

	$pdf->SetY($Y_Table_Position);
	$pdf->SetX(55);
	$pdf->MultiCell(25,6,$column_absen,1,'C');

	$pdf->SetY($Y_Table_Position);
	$pdf->SetX(80);
	$pdf->MultiCell(25,6,$column_tugas,1,'C');

	$pdf->SetY($Y_Table_Position);
	$pdf->SetX(105);
	$pdf->MultiCell(25,6,$column_uts,1,'C');

	$pdf->SetY($Y_Table_Position);
	$pdf->SetX(130);
	$pdf->MultiCell(25,6,$column_uas,1,'C');

	$pdf->SetY($Y_Table_Position);
	$pdf->SetX(155);
	$pdf->MultiCell(25,6,$column_total,1,'C');

	$pdf->SetY($Y_Table_Position);
	$pdf->SetX(180);
	$pdf->MultiCell(25,6,$column_range,1,'C');
	
	$Y_Table_Position = 250;
	
	//Now show the columns
	$pdf->SetFont('Arial','',10);

	$pdf->SetX($X_Table_Position);
	$pdf->SetY(5);
	$pdf->MultiCell(60,6,$sks,1,'C');

	$pdf->SetX($X_Table_Position);
	$pdf->SetY(60);
	$pdf->MultiCell(60,6,$jumlah_matakuliah,1,'C');

	$pdf->SetX($X_Table_Position);
	$pdf->SetY(120);
	$pdf->MultiCell(60,6,$ips,1,'C');

	// $pdf->Output();
	$pdf->Output($nimMahasiswa.'-'.$namaKelas.'.pdf','D');

    // echo $namaMahasiswa." ".$nimMahasiswa;
	// echo $idKelas."-".$idMahasiswa;
?>