



let exibirsolicitacoes = document.querySelector('#click1');
let exibirconsultas = document.querySelector('#click2');
let exibirexames = document.querySelector('#click3');


exibirsolicitacoes.addEventListener('click', function () {

  if (msolicitacao.style.display === 'block') {
    msolicitacao.style.display = 'none';
    consultas.style.display = 'none';
    exames.style.display = 'none';

  } else {
    msolicitacao.style.display = 'block';
    consultas.style.display = 'none'
    exames.style.display = 'none';

  }
});

exibirconsultas.addEventListener('click', function () {
  if (consultas.style.display === 'block') {
    msolicitacao.style.display = 'none';
    consultas.style.display = 'none'
    exames.style.display = 'none';
  } else {
    msolicitacao.style.display = 'none';
    consultas.style.display = 'block'
    exames.style.display = 'none';
  }

});

exibirexames.addEventListener('click', function () {
  if (exames.style.display === 'block') {
    msolicitacao.style.display = 'none';
    consultas.style.display = 'none'
    exames.style.display = 'none';
  } else {
    msolicitacao.style.display = 'none';
    consultas.style.display = 'none'
    exames.style.display = 'block';

  }

});