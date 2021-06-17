<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Login</title>
<link rel="stylesheet" href="../Meu.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
	crossorigin="anonymous">



</head>
<body>
	<div class="container">
		<div class="content first-content">
			<div class="first-column">
				<h2 class="title title-primary">bem vindo!</h2>
				<p class="description description-primary">Para se manter
					conectado com a gente</p>
				<p class="description description-primary">por favor logue com
					seus dados pessoais</p>
				<button id="signin" class="btn btn-primary">Entrar</button>
			</div>
			<div class="second-column">
				<h2 class="title title-second">Criar conta</h2>
				<div class="social-media">
					<ul class="list-social-media">
						<a class="link-social-media" href="#">
							<li class="item-social-media"><i class="fab fa-facebook-f"></i>
						</li>
						</a>
						<a class="link-social-media" href="#">
							<li class="item-social-media"><i
								class="fab fa-google-plus-g"></i></li>
						</a>
						<a class="link-social-media" href="#">
							<li class="item-social-media"><i class="fab fa-linkedin-in"></i>
						</li>
						</a>
					</ul>
				</div>
				<!-- social media -->
				<p class="description description-second">ou use seu e-mail para
					registro:</p>

				<form action="createuser" method="POST">
					<label class="label-input" for=""> <i
						class="far fa-user icon-modify"></i> <input type="text"
						name="nome" placeholder="Nome">
					</label> <label class="label-input" for=""> <i
						class="far fa-envelope icon-modify"></i> <input type="email"
						name="email" placeholder="Email">
					</label> <label class="label-input" for=""> <i
						class="far fa-user icon-modify"></i> <input type="text"
						name="cpf" placeholder="CPF">
					</label> <label class="label-input" for=""> <i
						class="fas fa-lock icon-modify"></i> <input type="password"
						name="senha" placeholder="Senha">
					</label>


					<button type="submit" class="btn btn-second">Inscrever-se</button>
				</form>
			</div>
			<!-- second column -->
		</div>



		<!-- first content -->
		<div class="content second-content">
			<div class="first-column">
				<h2 class="title title-primary">Bem Vindo, amigo!</h2>
				<h6 class="description description-primary">Insira seus dados
					pessoais</h6>
				<p class="description description-primary">e comece a jornada
					conosco</p>
				<button id="signup" class="btn btn-primary">Inscrever-se</button>
			</div>
			<div class="second-column">
				<h2 class="title title-second">InfoMoney</h2>
				<div class="social-media">
					<ul class="list-social-media">
						<a class="link-social-media" href="#">
							<li class="item-social-media"><i class="fab fa-facebook-f"></i>
						</li>
						</a>
						<a class="link-social-media" href="#">
							<li class="item-social-media"><i
								class="fab fa-google-plus-g"></i></li>
						</a>
						<a class="link-social-media" href="#">
							<li class="item-social-media"><i class="fab fa-linkedin-in"></i>
						</li>
						</a>
					</ul>
				</div>
				<!-- social media -->
				<p class="description description-second">ou use sua conta de
					e-mail:</p>
				<form class="form" action="login" method="POST">

					<label class="label-input" for=""> <i
						class="far fa-envelope icon-modify"></i> <input type="email"
						name="email" placeholder="Email">
					</label> <label class="label-input" for=""> <i
						class="fas fa-lock icon-modify"></i> <input type="password"
						name="senha" placeholder="Password">
					</label> <a class="password" href="#">Esqueceu sua senha ?</a>
					<button type="submit" class="btn btn-second">Entrar</button>
				</form>
			</div>
			<!-- second column -->
		</div>
		<!-- second-content -->
	</div>

</body>
<script type="text/javascript">
	var btnSignin = document.querySelector("#signin");
	var btnSignup = document.querySelector("#signup");

	var body = document.querySelector("body");

	btnSignin.addEventListener("click", function() {
		body.className = "sign-in-js";
	});

	btnSignup.addEventListener("click", function() {
		body.className = "sign-up-js";
	})
</script>
</html>