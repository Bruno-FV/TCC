(() => {
  'use strict'

  // busca todos os formularios para aplicar a validação
  const forms = document.querySelectorAll('.needs-validation');
  
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        
        event.preventDefault();
        event.stopPropagation();
      }

      form.classList.add('was-validated')
    }, false)
  })
})()
/***********Evento para verificar as senhas no cadastro*********************************/
let salvar = document.querySelector('#salvar');

salvar.addEventListener('click', function (event){
  let verificarSenha = document.querySelector('#confirmarSenha').value;
  let senha = document.querySelector('#senha').value;
  if(senha != verificarSenha){    
      alert("As senhas devem ser iguais!");
      event.preventDefault();
  }
});
/*************Evento para verificar data de nascimento*******************/

salvar.addEventListener('click', function (event){
  let dataNasc = document.querySelector('#dataNascimento').value;
  console.log(dataNasc)
  let dataAtual = new Date();
  if(dataNasc > dataAtual){    
      alert("data incorreta");

      event.preventDefault();
  }
});

