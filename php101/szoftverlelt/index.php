<?php
session_start();
require_once("control/control.php");
require_once("control/header.php");
?>

	<body>
		<div class="modal fade" id="newcomputer" tabindex="-1" role="dialog">
		  <div class="modal-dialog" role="document">
			<div class="modal-content">
			  <div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel"><h2>Új gép felvétele</h2></h5>
				<button type="button" class="close" data-dismiss="modal">
				  <span aria-hidden="true"><i class="fas fa-times-circle"></i></span>
				</button>
			  </div>
			  <div class="modal-body">
				<form method="post" action="<?php echo HOME; ?>">
					<div class="form-group">
						<label>Hely:</label>
						<input class="form-control" type="text" name="hely" required>
						<small class="text-muted d-block">Írja be a szobaszámot, ahol a számítógép található (pl.: T301)</small>
					</div>
					<div class="form-group">
						<label>Típus:</label>
						<select class="form-control" name="tipus" required>
							<option value="notebook">Notebook</option>
							<option value="asztali">Asztali</option>
						</select>
					</div>
					<div class="form-group">
						<label>IP cím:</label>
						<input class="form-control" type="text" name="ipcim" required>		 
					</div>
					<div class="form-group form-inline">
					</div>
			  </div>
			  <div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Mégsem</button>
				<button type="submit" class="btn btn-primary ml-auto" name="event" value="addnewcomp">
					<i class="fas fa-file-upload"></i> Felvitel
				</button>
			  </div>
			  </form>
			</div>
		  </div>
		</div>
		
		<div class="container-fluid">
			<div class="container bg-light pt-3 pb-3 rounded">
				<h1 class="text-center">Számítógépek</h1>
				<small><ul class="pagination">
<?php
					for($i=0; $i<count($allcomputers)/10; $i++){
						if($i+1 == $page){
?>
						<li class="page-item active"><a class="page-link" href="<?php echo HOME; ?>page/<?php echo $i+1;?>"><?php echo $i+1;?></a></li>
<?php
						} else {
?>					
						<li class="page-item"><a class="page-link" href="<?php echo HOME; ?>page/<?php echo $i+1;?>"><?php echo $i+1;?></a></li>
<?php
						}
					}
?>
					</ul></small>				
						<div class="row bg-dark text-light sticky-top text-center font-weight-bold">
							<div class="col-6 col-md-2">ID</div>
							<div class="col-6 col-md-4">Hely / Típus</div>
							<div class="col-6 col-md-4">IP-cím</div>
							<div class="col-6 col-md-2">Megtekintés</div>
						</div>
<?php
						foreach($computers as $sor){
?>
						<div class="row border-bottom mb-1 pb-1 pt-1 text-center">
							<div class="col-6 col-md-2">
								<?php echo $sor['id']; ?>
							</div>
							<div class="col-6 col-md-4">
								<?php echo $sor['hely']; ?><br>
								<?php echo $sor['tipus']; ?>
							</div>
							<div class="col-6 col-md-4">
								<?php echo $sor['ipcim']; ?>
							</div>
							<div class="col-6 col-md-2">
								<a class="btn btn-secondary" href="<?php echo HOME; ?>computer/<?php echo $sor['id']; ?>">
									<i class="fas fa-external-link-alt"></i>
								</a>
							</div>
						</div>
<?php
						}
?>
					</table>
					<small><ul class="pagination">
<?php
					for($i=0; $i<count($allcomputers)/10; $i++){
						if($i+1 == $page){
?>
						<li class="page-item active"><a class="page-link" href="<?php echo HOME; ?>page/<?php echo $i+1;?>"><?php echo $i+1;?></a></li>
<?php
						} else {
?>					
						<li class="page-item"><a class="page-link" href="<?php echo HOME; ?>page/<?php echo $i+1;?>"><?php echo $i+1;?></a></li>
<?php
						}
					}
					//set session page to the current page
					$_SESSION['page'] = $page;
?>
					</ul></small>
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#newcomputer">
						<i class="fas fa-plus"></i> Új gép
					</button>
					<a class="btn btn-primary" href="<?php echo HOME; ?>softwares/">
						<i class="fas fa-list"></i> Szoftverek
					</a>

			</div>
		</div>
		<script>
			<?php echo $feedbackmessage; ?>
		</script>
	</body>

</html>
