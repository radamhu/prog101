<?php
session_start();
require_once("control.php");
require_once("header.php");

//get software kategories
$swkatquery = mysqli_query($db, "select kategoria from szoftver group by kategoria");
$swkat = mysqli_fetch_all($swkatquery, MYSQLI_ASSOC);


?>
	<body>
	
	<div class="modal fade" id="addnewsoft" tabindex="-1" role="dialog">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel"><h2>Új szoftver felvétele</h2></h5>
				<button type="button" class="close" data-dismiss="modal">
				  <span aria-hidden="true"><i class="fas fa-times-circle"></i></span>
				</button>
			  </div>
			  <div class="modal-body">
				<form method="post" action="<?php echo HOME; ?>softwares/">
					<div class="form-group">
						<label>Név:</label>
						<input class="form-control" type="text" name="swname" required>
					</div>
					<div class="form-group">
						<label>Kategória:</label>
						<select class="form-control" name="swkat" id="editable-select" required>
<?php
							foreach($swkat as $kats) {
?>
								<option value="<?php echo $kats["kategoria"]; ?>"><?php echo $kats["kategoria"]; ?></option>
<?php
							}
?>
						</select>
					</div>
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Mégsem</button>
				<button type="submit" class="btn btn-primary ml-auto" name="event" value="addnewsoft">
					<i class="fas fa-file-upload"></i> Felvitel
				</button>
			  </div>
			  </form>
			</div>
		  </div>
		</div>
		
		<div class="container-fluid">
			<div class="container bg-light mt-3 mb-3 rounded p-3">
				<h1 class="text-center">Szoftverek</h1>
				<div class="mb-2 text-right">
					<a class="btn btn-primary" href="<?php echo $backlink; ?>">
						<i class="fas fa-arrow-left"></i> Vissza a gépekhez
					</a>
					<button class="btn btn-primary" data-toggle="modal" data-target="#addnewsoft">
						<i class="fas fa-plus"></i> Új szoftver hozzáadása
					</button>
				</div>
				<div class="row bg-dark text-light font-weight-bold mb-2 sticky-top">
					<div class="col-2">ID</div>
					<div class="col-7">Név / kategória</div>
					<div class="col-3"></div>
				</div>
<?php
					foreach($swr as $swsor) {
?>
					<div class="row">
						<div class="col-2"><?php echo $swsor["id"]; ?></div>
						<div class="col-7">
							<b><?php echo $swsor["nev"]; ?></b><br>
							<?php echo $swsor["kategoria"]; ?>
						</div>
						<div class="col-3">
							<form action="<?php echo HOME; ?>softwares/" method="post">
								<input class="d-none" value="<?php echo $swsor["id"]; ?>" name="swid">
								<button class="btn btn-danger" name="event" value="swremove" type="submit"><i class="fas fa-trash-alt"></i></button>
							</form>
						</div>
					</div>
<?php						
					}
?>
				<div class="mt-2">
				<a class="btn btn-primary" href="<?php echo $backlink; ?>">
					<i class="fas fa-arrow-left"></i> Vissza a gépekhez
				</a>
				<button class="btn btn-primary" data-toggle="modal" data-target="#addnewsoft">
					<i class="fas fa-plus"></i> Új szoftver hozzáadása
				</button>
				</div>
			</div>
		</div>
		<script>
			<?php echo $feedbackmessage; ?>
			$("#editable-select").editableSelect();
		</script>
	</body>

</html>