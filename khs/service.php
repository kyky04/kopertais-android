<?php
    
    include("config.php");
    session_start();

    $response = array();
    if (isset($_POST['function'])){
        $function = $_POST['function'];

        if($function=="Login"){
            // echo md5("admin");
            $username = $_POST['username']; 
            $password = md5($_POST['password']);
            //Cek di Admin
            $sql = "SELECT * FROM tb_admin WHERE username = '$username' and password = '$password'";
            $result = mysqli_query($db,$sql);
            $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
            $count = mysqli_num_rows($result);
            if($count == 1) {
                $response["success"] = 1;
                $response["message"] = "Login berhasil";
                $response["name"] = $row['username'];
                $response["id"] = $row['recid'];
                $response["userid"] = $row['recid'];
                $response["admin"] = 0;
            }else {
                //Cek di Dosen
                $sql = "SELECT * FROM tb_dosen WHERE nip = '$username' and password = '$password'";
                $result = mysqli_query($db,$sql);
                $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
                $count = mysqli_num_rows($result);
                if($count == 1) {
                    $response["success"] = 1;
                    $response["message"] = "Login berhasil";
                    $response["name"] = $row['nama'];
                    $response["id"] = $row['recid'];
                    $response["userid"] = $row['nip'];
                    $response["admin"] = 1;
                }else {
                    //Cek di Mahasiswa
                    $sql = "SELECT * FROM tb_mahasiswa WHERE tanggal_lahir = '$username' and password = '$password'";
                    $result = mysqli_query($db,$sql);
                    $row = mysqli_fetch_array($result,MYSQLI_ASSOC);
                    $count = mysqli_num_rows($result);
                    if($count == 1) {
                        $response["success"] = 1;
                        $response["message"] = "Login berhasil";
                        $response["name"] = $row['nama'];
                        $response["id"] = $row['recid'];
                        $response["userid"] = $row['tanggal_lahir'];
                        $response["admin"] = 2;
                    }else {
                        $response["success"] = 0;
                        $response["message"] = "Username atau password salah";
                    }
                }
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="AddKelas"){
            $nama= $_POST['nama'];
            $semester= $_POST['semester'];
            $kategori= $_POST['kategori'];
            $idKelas = $_POST['id'];
            if($idKelas ==''){
                //Insert Kelas
                $sql = "INSERT INTO tb_kelas (nama,semester,kategori) VALUES ('$nama','$semester','$kategori') ";
                $result = mysqli_query($db,$sql);
                if($result){
                    $response["message"] = 'Tambah kelas sukses';
                    $response["success"] = 1;
                }else{
                    $response["message"] = 'Tambah kelas gagal';
                    $response["success"] = 0;
                }
            }else{
                //Update Kelas
                $sql = "UPDATE tb_kelas SET nama= '$nama', semester= '$semester', kategori= '$kategori' WHERE recid = '$idKelas ' ";
                $result = mysqli_query($db,$sql);
                if($result){
                        $response["message"] = 'Update kelas sukses';
                        $response["success"] = 1;
                }else{
                    $response["message"] = 'Update kelas gagal';
                    $response["success"] = 0;
                }
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="ListKelas"){
            $sql = "SELECT * FROM tb_kelas ORDER BY nama ASC";
            if ($result=mysqli_query($db,$sql)){
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
                    $listIsi = array();
                    $listIsi['nama'] = $row['nama'];
                    $listIsi['semester'] = $row['semester'];
                    $listIsi['kategori'] = $row['kategori'];
                    $listIsi['recid'] = $row['recid'];
                    $response[] = $listIsi;
                }
                mysqli_free_result($result);
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="DeleteKelas"){
            $id= $_POST['id'];
            $sql = "DELETE FROM tb_kelas WHERE recid = '$id' ";
            $result = mysqli_query($db,$sql);
            if($result){
                $response["message"] = 'Delete kelas sukses';
                $response["success"] = 1;
            }else{
                $response["message"] = 'Delete kelas gagal';
                $response["success"] = 0;
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="AddMatkul"){
            $nama= $_POST['nama'];
            $sks= $_POST['sks'];
            $dosen= $_POST['dosen'];
            $id= $_POST['id'];
            if($id==''){
                //Insert Matkul
                $sql = "INSERT INTO tb_matkul (nama,sks,dosen) VALUES ('$nama','$sks','$dosen') ";
                $result = mysqli_query($db,$sql);
                if($result){
                    $response["message"] = 'Tambah matkul sukses';
                    $response["success"] = 1;
                }else{
                    $response["message"] = 'Tambah matkul gagal';
                    $response["success"] = 0;
                }
            }else{
                //Update Matkul
                $sql = "UPDATE tb_matkul SET nama= '$nama', sks= '$sks', dosen= '$dosen' WHERE recid = '$id ' ";
                $result = mysqli_query($db,$sql);
                if($result){
                        $response["message"] = 'Update matkul sukses';
                        $response["success"] = 1;
                }else{
                    $response["message"] = 'Update matkul gagal';
                    $response["success"] = 0;
                }
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="ListMatkul"){
            $sql = "SELECT a.recid, a.nama, a.sks, b.nama AS 'dosen' FROM tb_matkul a, tb_dosen b WHERE a.dosen = b.recid ORDER BY a.nama";
            if ($result=mysqli_query($db,$sql)){
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
                    $listIsi = array();
                    $listIsi['nama'] = $row['nama'];
                    $listIsi['sks'] = $row['sks'];
                    $listIsi['dosen'] = $row['dosen'];
                    $listIsi['recid'] = $row['recid'];
                    $response[] = $listIsi;
                }
                mysqli_free_result($result);
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="DeleteMatkul"){
            $id= $_POST['id'];
            $sql = "DELETE FROM tb_matkul WHERE recid = '$id' ";
            $result = mysqli_query($db,$sql);
            if($result){
                $response["message"] = 'Delete matkul sukses';
                $response["success"] = 1;
            }else{
                $response["message"] = 'Delete matkul gagal';
                $response["success"] = 0;
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="AddDosen"){
            $nama= $_POST['nama'];
            $nip= $_POST['nip'];
            $password = md5($_POST['password']);
            $no_hp= $_POST['no_hp'];
            $id= $_POST['id'];
            if($id==''){
                //Insert Matkul
                $sql = "INSERT INTO tb_dosen (nama,nip,password,no_hp) VALUES ('$nama','$nip','$password','$no_hp') ";
                $result = mysqli_query($db,$sql);
                if($result){
                    $response["message"] = 'Tambah dosen sukses';
                    $response["success"] = 1;
                }else{
                    $response["message"] = 'Tambah dosen gagal';
                    $response["success"] = 0;
                }
            }else{
                //Update Matkul
                $sql = "UPDATE tb_dosen SET nama= '$nama', nip= '$nip',password = '$password', no_hp= '$no_hp' WHERE recid = '$id ' ";
                $result = mysqli_query($db,$sql);
                if($result){
                        $response["message"] = 'Update dosen sukses';
                        $response["success"] = 1;
                }else{
                    $response["message"] = 'Update dosen gagal';
                    $response["success"] = 0;
                }
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="ListDosen"){
            $sql = "SELECT * FROM tb_dosen ORDER BY nama ASC";
            if ($result=mysqli_query($db,$sql)){
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
                    $listIsi = array();
                    $listIsi['nama'] = $row['nama'];
                    $listIsi['nip'] = $row['nip'];
                    $listIsi['hp'] = $row['no_hp'];
                    $listIsi['recid'] = $row['recid'];
                    $response[] = $listIsi;
                }
                mysqli_free_result($result);
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="DeleteDosen"){
            $id= $_POST['id'];
            $sql = "DELETE FROM tb_dosen WHERE recid = '$id' ";
            $result = mysqli_query($db,$sql);
            if($result){
                $response["message"] = 'Delete dosen sukses';
                $response["success"] = 1;
            }else{
                $response["message"] = 'Delete dosen gagal';
                $response["success"] = 0;
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="AddMahasiswa"){
            $nama= $_POST['nama'];
            $tanggal_lahir= $_POST['tanggal_lahir'];
            $password = md5($_POST['password']);
            $no_hp= $_POST['no_hp'];
            $alamat = $_POST['alamat'];
            $jurusan = $_POST['jurusan'];
            $id= $_POST['id'];
            if($id==''){
                //Insert Mahasiswa
                $sql = "INSERT INTO tb_mahasiswa (nama,tanggal_lahir,password,no_hp,alamat,jurusan) VALUES ('$nama','$tanggal_lahir','$password','$no_hp','$alamat','$jurusan') ";
                $result = mysqli_query($db,$sql);
                if($result){
                    $response["message"] = 'Tambah mahasiswa sukses';
                    $response["success"] = 1;
                }else{
                    $response["message"] = 'Tambah mahasiswa gagal';
                    $response["success"] = 0;
                }
            }else{
                //Update Mahasiswa
                $sql = "UPDATE tb_mahasiswa SET nama= '$nama', tanggal_lahir= '$tanggal_lahir',password = '$password', no_hp= '$no_hp', alamat = '$alamat', jurusan = '$jurusan' WHERE recid = '$id ' ";
                $result = mysqli_query($db,$sql);
                if($result){
                        $response["message"] = 'Update mahasiswa sukses';
                        $response["success"] = 1;
                }else{
                    $response["message"] = 'Update mahasiswa gagal';
                    $response["success"] = 0;
                }
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="ListMahasiswa"){
            $sql = "SELECT * FROM tb_mahasiswa ORDER BY nama ASC";
            if ($result=mysqli_query($db,$sql)){
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
                    $listIsi = array();
                    $listIsi['nama'] = $row['nama'];
                    $listIsi['tanggal_lahir'] = $row['tanggal_lahir'];
                    $listIsi['hp'] = $row['no_hp'];
                    $listIsi['alamat'] = $row['alamat'];
                    $listIsi['jurusan'] = $row['jurusan'];
                    $listIsi['recid'] = $row['recid'];
                    $response[] = $listIsi;
                }
                mysqli_free_result($result);
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="DeleteMahasiswa"){
            $id= $_POST['id'];
            $sql = "DELETE FROM tb_mahasiswa WHERE recid = '$id' ";
            $result = mysqli_query($db,$sql);
            if($result){
                $response["message"] = 'Delete mahasiswa sukses';
                $response["success"] = 1;
            }else{
                $response["message"] = 'Delete mahasiswa gagal';
                $response["success"] = 0;
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="AddKelasMatkul"){
            $idKelas= $_POST['idKelas'];
            $idMatkul= $_POST['idMatkul'];
            $id= $_POST['id'];
            if($id==''){
            	//Insert Kelas
            	$sql = "INSERT INTO tb_kelas_group (id_kelas,id_matkul) VALUES ('$idKelas','$idMatkul') ";
            	$result = mysqli_query($db,$sql);
            	if($result){
                    $response["message"] = 'Tambah kelas group sukses';
                    $response["success"] = 1;
            	}else{
                    $response["message"] = 'Tambah kelas group gagal';
                    $response["success"] = 0;
                }
            }else{
            	$sql = "DELETE FROM tb_kelas_group WHERE recid = '$id' ";
            	$result = mysqli_query($db,$sql);
            	if($result){
                    $response["message"] = 'Delete kelas group sukses';
                    $response["success"] = 1;
            	}else{
                    $response["message"] = 'Delete kelas group gagal';
                    $response["success"] = 0;
                }
            }
	    
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="ListKelasMatkul"){
            $idKelas= $_POST['idKelas'];
            $notin = "";
            $sql = "SELECT * FROM tb_kelas_group WHERE id_kelas = $idKelas GROUP BY (id_matkul)";
            if ($result=mysqli_query($db,$sql)){
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
                    $notin = $notin.$row['id_matkul'].",";
                }
                mysqli_free_result($result);
            }
            $notin = rtrim($notin, ",");
            if($notin!=""){
                $sql = "SELECT a.recid, a.nama, a.sks, b.nama AS 'dosen' FROM tb_matkul a, tb_dosen b WHERE a.dosen = b.recid AND a.recid NOT IN ($notin) ORDER BY a.nama";
            }else{
                $sql = "SELECT a.recid, a.nama, a.sks, b.nama AS 'dosen' FROM tb_matkul a, tb_dosen b WHERE a.dosen = b.recid ORDER BY a.nama";
            }
            // echo $notin;
            
            if ($result=mysqli_query($db,$sql)){
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
                    $listIsi = array();
                    $listIsi['nama'] = $row['nama'];
                    $listIsi['sks'] = $row['sks'];
                    $listIsi['dosen'] = $row['dosen'];
                    $listIsi['recid'] = $row['recid'];
                    $response[] = $listIsi;
                }
                mysqli_free_result($result);
            }
            // echo $sql;
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="ListMatkulPerKelas"){
            $idKelas= $_POST['idKelas'];
            $idDosen= $_POST['idDosen'];
            $sql = "";
            if($idDosen==""){
                $sql = "SELECT a.recid,b.nama,b.sks,b.recid AS recidMatkul FROM tb_kelas_group a, tb_matkul b WHERE a.id_matkul = b.recid and a.id_kelas = $idKelas";
            }else{
                $sql = "SELECT a.recid,b.nama,b.sks,b.recid AS recidMatkul FROM tb_kelas_group a, tb_matkul b WHERE a.id_matkul = b.recid and a.id_kelas = $idKelas AND b.dosen = '$idDosen'";
            }
            if ($result=mysqli_query($db,$sql)){
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
                    $listIsi = array();
                    $listIsi['nama'] = $row['nama'];
                    $listIsi['sks'] = $row['sks'];
                    $listIsi['recid'] = $row['recid'];
                    $listIsi['recidMatkul'] = $row['recidMatkul'];
                    $response[] = $listIsi;
                }
                mysqli_free_result($result);
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="DeletematkulFromKelas"){
            $id= $_POST['id'];
            $sql = "DELETE FROM tb_kelas_group WHERE recid = '$id' ";
            $result = mysqli_query($db,$sql);
            if($result){
                $response["message"] = 'Delete matkul dari kelas sukses';
                $response["success"] = 1;
            }else{
                $response["message"] = 'Delete matkul dari kelas gagal';
                $response["success"] = 0;
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="AddKelasMahasiswa"){
            $idKelas= $_POST['idKelas'];
            $idMahasiswa= $_POST['idMahasiswa'];
            $idMatkul= $_POST['idMatkul'];
            $id= $_POST['id'];
            if($id==''){
                //Insert Kelas
                $sql = "INSERT INTO tb_kelas_mahasiswa (id_kelas,id_mahasiswa,id_matkul) VALUES ('$idKelas','$idMahasiswa','$idMatkul') ";
                $result = mysqli_query($db,$sql);
                if($result){
                    $response["message"] = 'Tambah kelas mahasiswa sukses';
                    $response["success"] = 1;
                }else{
                    $response["message"] = 'Tambah kelas mahasiswa gagal';
                    $response["success"] = 0;
                }
            }else{
                $sql = "DELETE FROM tb_kelas_mahasiswa WHERE recid = '$id' ";
                $result = mysqli_query($db,$sql);
                if($result){
                    $response["message"] = 'Delete kelas mahasiswa sukses';
                    $response["success"] = 1;
                }else{
                    $response["message"] = 'Delete kelas mahasiswa gagal';
                    $response["success"] = 0;
                }
            }
        
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="ListMahasiswaPerKelas"){
            $idKelas= $_POST['idKelas'];
            $idMatkul= $_POST['idMatkul'];
            $sql = "SELECT a.recid,b.nama,b.tanggal_lahir,b.jurusan FROM tb_kelas_mahasiswa a, tb_mahasiswa b WHERE b.recid = a.id_mahasiswa and a.id_kelas = $idKelas AND a.id_matkul = '$idMatkul' ";
            if ($result=mysqli_query($db,$sql)){
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
                    $listIsi = array();
                    $listIsi['nama'] = $row['nama'];
                    $listIsi['tanggal_lahir'] = $row['tanggal_lahir'];
                    $listIsi['jurusan'] = $row['jurusan'];
                    $listIsi['recid'] = $row['recid'];
                    $response[] = $listIsi;
                }
                mysqli_free_result($result);
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="DeleteMahasiswaFromKelas"){
            $id= $_POST['id'];
            $sql = "DELETE FROM tb_kelas_mahasiswa WHERE recid = '$id' ";
            $result = mysqli_query($db,$sql);
            if($result){
                $response["message"] = 'Delete mahasiswa dari kelas sukses';
                $response["success"] = 1;
            }else{
                $response["message"] = 'Delete mahasiswa dari kelas gagal';
                $response["success"] = 0;
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="ListKelasMahasiswa"){
            $idKelas= $_POST['idKelas'];
            $idMatkul= $_POST['idMatkul'];
            $notin = "";
            $sql = "SELECT * FROM tb_kelas_mahasiswa WHERE id_kelas = $idKelas AND id_matkul = '$idMatkul' GROUP BY (id_mahasiswa)";
            if ($result=mysqli_query($db,$sql)){
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
                    $notin = $notin.$row['id_mahasiswa'].",";
                }
                mysqli_free_result($result);
            }
            $notin = rtrim($notin, ",");
            if($notin==""){
                $sql = "SELECT recid, nama, tanggal_lahir, jurusan FROM tb_mahasiswa ORDER BY nama";
            }else{
                $sql = "SELECT recid, nama, tanggal_lahir, jurusan FROM tb_mahasiswa WHERE recid NOT IN ($notin) ORDER BY nama";
            }
            if ($result=mysqli_query($db,$sql)){
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
                    $listIsi = array();
                    $listIsi['nama'] = $row['nama'];
                    $listIsi['tanggal_lahir'] = $row['tanggal_lahir'];
                    $listIsi['jurusan'] = $row['jurusan'];
                    $listIsi['recid'] = $row['recid'];
                    $response[] = $listIsi;
                }
                mysqli_free_result($result);
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="ListKelasPerDosen"){
            $idDosen= $_POST['idDosen'];
            $sql = "SELECT * FROM tb_matkul WHERE dosen = $idDosen";
            $recidIn = "";
            if ($result=mysqli_query($db,$sql)){
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
                    $recidIn = $recidIn.$row['recid'].",";
                }
                mysqli_free_result($result);
            }
            $recidIn = rtrim($recidIn, ",");
            $sql = "SELECT * FROM tb_kelas_group WHERE id_matkul IN ($recidIn) GROUP BY (id_kelas)";
            $recidIn = "";
            if ($result=mysqli_query($db,$sql)){
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
                    $recidIn = $recidIn.$row['id_kelas'].",";
                }
                mysqli_free_result($result);
            }
            $recidIn = rtrim($recidIn, ",");
            // echo $recidIn;
            $sql = "SELECT * FROM tb_kelas WHERE recid IN ($recidIn) ORDER BY nama";
            if ($result=mysqli_query($db,$sql)){
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
                    $listIsi = array();
                    $listIsi['nama'] = $row['nama'];
                    $listIsi['semester'] = $row['semester'];
                    $listIsi['recid'] = $row['recid'];
                    $response[] = $listIsi;
                }
                mysqli_free_result($result);
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="ListNilaiMahasiswaPerKelas"){
            $idKelas= $_POST['idKelas'];
            $idMatkul= $_POST['idMatkul'];
            $sql = "SELECT a.recid,a.nilai_absen, a.nilai_tugas, a.nilai_uts, a.nilai_uas, a.range_nilai, b.nama,b.tanggal_lahir,b.jurusan FROM tb_kelas_mahasiswa a, tb_mahasiswa b WHERE b.recid = a.id_mahasiswa and a.id_kelas = $idKelas and a.id_matkul = '$idMatkul'";
            if ($result=mysqli_query($db,$sql)){
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
                    $listIsi = array();
                    $listIsi['nama'] = $row['nama'];
                    $listIsi['tanggal_lahir'] = $row['tanggal_lahir'];
                    $listIsi['jurusan'] = $row['jurusan'];
                    $listIsi['nilai_absen'] = $row['nilai_absen'];
                    $listIsi['nilai_tugas'] = $row['nilai_tugas'];
                    $listIsi['nilai_uts'] = $row['nilai_uts'];
                    $listIsi['nilai_uas'] = $row['nilai_uas'];
                    $listIsi['range_nilai'] = $row['range_nilai'];
                    $listIsi['recid'] = $row['recid'];
                    $response[] = $listIsi;
                }
                mysqli_free_result($result);
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="UpdateNilaiMahasiswa"){
            $idMahasiswa= $_POST['idMahasiswa'];
            $nilai_absen= $_POST['nilai_absen'];
            $nilai_tugas= $_POST['nilai_tugas'];
            $nilai_uts= $_POST['nilai_uts'];
            $nilai_uas= $_POST['nilai_uas'];

            $nilai_absen_percent = $nilai_absen * 10 / 100;
            $nilai_tugas_percent = $nilai_tugas * 20 / 100;
            $nilai_uts_percent = $nilai_uts * 30 / 100;
            $nilai_uas_percent = $nilai_uas * 40 / 100;
            $total_nilai = $nilai_absen_percent + $nilai_tugas_percent + $nilai_uts_percent + $nilai_uas_percent;
            $range_nilai = "";
            if($total_nilai >= 80){
                $range_nilai = "A";
            }else if(($total_nilai >= 69)&&($total_nilai <= 79)){
                $range_nilai = "B";
            }else if(($total_nilai >= 55)&&($total_nilai <= 68)){
                $range_nilai = "C";
            }else if(($total_nilai >= 40)&&($total_nilai <=54)){
                $range_nilai = "D";
            }else if(($total_nilai >= 0)&&($total_nilai <= 39)){
                $range_nilai = "E";
            }

            //echo $total_nilai." ".$range;

            //Update Nilai
            $sql = "UPDATE tb_kelas_mahasiswa SET range_nilai= '$range_nilai', nilai_absen= $nilai_absen, nilai_uts= $nilai_uts , nilai_uas= $nilai_uas , nilai_tugas= $nilai_tugas WHERE recid = '$idMahasiswa ' ";
            
            $result = mysqli_query($db,$sql);
            if($result){
                    $response["message"] = 'Update nilai sukses';
                    $response["success"] = 1;
            }else{
                $response["message"] = 'Update nilai gagal';
                $response["success"] = 0;
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="ListKelasPerMahasiswa"){
            $idMahasiswa= $_POST['idMahasiswa'];
            $sql = "SELECT b.nama, b.semester, b.recid FROM tb_kelas_mahasiswa a, tb_kelas b WHERE id_mahasiswa = '$idMahasiswa' GROUP BY (id_mahasiswa)";
            if ($result=mysqli_query($db,$sql)){
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
                    $listIsi = array();
                    $listIsi['nama'] = $row['nama'];
                    $listIsi['semester'] = $row['semester'];
                    $listIsi['recid'] = $row['recid'];
                    $response[] = $listIsi;
                }
                mysqli_free_result($result);
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }elseif($function=="ListNilaiPerMahasiswa"){
            $idMahasiswa = $_POST['idMahasiswa'];
            $idKelas = $_POST['idKelas'];
            // $sql = "SELECT a.recid,a.nilai_absen, a.nilai_tugas, a.nilai_uts, a.nilai_uas, a.id_matkul, a.range_nilai, b.nama,b.tanggal_lahir,b.jurusan FROM tb_kelas_mahasiswa a, tb_mahasiswa b WHERE b.recid = a.id_mahasiswa and a.id_mahasiswa = '$idMahasiswa' AND a.id_kelas = '$idKelas'";
            // echo $sql;
            $sql = "SELECT
                    a.recid,
                    a.nilai_absen,
                    a.nilai_tugas,
                    a.nilai_uts,
                    a.nilai_uas,
                    a.id_matkul,
                    a.range_nilai,
                    b.tanggal_lahir,
                    b.jurusan,
                    c.nama
                FROM
                    tb_kelas_mahasiswa a,
                    tb_mahasiswa b,
                    tb_matkul c
                WHERE
                    b.recid = a.id_mahasiswa
                AND c.recid = a.id_matkul
                AND a.id_mahasiswa = '$idMahasiswa'
                AND a.id_kelas = '$idKelas'";
            if ($result=mysqli_query($db,$sql)){
                while ($row=mysqli_fetch_array($result,MYSQLI_ASSOC)){
                    $listIsi = array();
                    $listIsi['nama'] = $row['nama'];
                    $listIsi['tanggal_lahir'] = $row['tanggal_lahir'];
                    $listIsi['jurusan'] = $row['jurusan'];
                    $listIsi['id_matkul'] = $row['id_matkul'];
                    $listIsi['nilai_absen'] = $row['nilai_absen'];
                    $listIsi['nilai_tugas'] = $row['nilai_tugas'];
                    $listIsi['nilai_uts'] = $row['nilai_uts'];
                    $listIsi['nilai_uas'] = $row['nilai_uas'];
                    $listIsi['range_nilai'] = $row['range_nilai'];
                    $listIsi['recid'] = $row['recid'];
                    $response[] = $listIsi;
                }
                mysqli_free_result($result);
            }
            $result = array();
            $result['hasil'] = $response;
            print(json_encode($result));
        }




    }else{
        // no fucntion
        $response["success"] = 0;
        $response["message"] = "Function missing";
        print(json_encode($response));
    }
?> 