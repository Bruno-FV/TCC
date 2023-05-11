/**
 * função para exibir e ocultar o conteudo do menu lateral
 */
window.onload = function () {

}
let exibirAtualizacao = document.querySelector('#click1');
let exibirRelatorios = document.querySelector('#click2')
let exibirConsultas = document.querySelector('#click3');
let exibirExames = document.querySelector('#click4');




exibirAtualizacao.addEventListener('click', function () {

  if (atualizacao.style.display === 'block') {
    atualizacao.style.display = 'none';
    relatorios.style.display = 'none';
    consultas.style.display = 'none';
    exames.style.display = 'none';

  } else {
    atualizacao.style.display = 'block';
    relatorios.style.display = 'none';
    consultas.style.display = 'none'
    exames.style.display = 'none';

  }
});
exibirRelatorios.addEventListener('click', function () {

  if (relatorios.style.display === 'block') {
    atualizacao.style.display = 'none';
    relatorios.style.display = 'none';
    consultas.style.display = 'none';
    exames.style.display = 'none';

  } else {
    relatorios.style.display = 'block';
    atualizacao.style.display = 'none';
    consultas.style.display = 'none'
    exames.style.display = 'none';

  }
});

exibirConsultas.addEventListener('click', function () {
  if (consultas.style.display === 'block') {
    atualizacao.style.display = 'none';
    relatorios.style.display = 'none';
    consultas.style.display = 'none'
    exames.style.display = 'none';
  } else {
    atualizacao.style.display = 'none';
    relatorios.style.display = 'none';
    consultas.style.display = 'block'
    exames.style.display = 'none';
  }

});

exibirExames.addEventListener('click', function () {
  if (exames.style.display === 'block') {
    atualizacao.style.display = 'none';
    relatorios.style.display = 'none';
    consultas.style.display = 'none'
    exames.style.display = 'none';
  } else {
    atualizacao.style.display = 'none';
    relatorios.style.display = 'none';
    consultas.style.display = 'none'
    exames.style.display = 'block';

  }

});

let exibirRelatorioConsultas = document.querySelector('#relatorioConsultas');
let exibirRelatorioExames = document.querySelector('#relatorioExames');

exibirRelatorioConsultas.addEventListener('click', function () {
  if (rConsultas.style.display === 'block') {
    rConsultas.style.display = 'none';
    rExames.style.display = 'none';
  } else {
    rConsultas.style.display = 'block';
    rExames.style.display = 'none';
  }

});
exibirRelatorioExames.addEventListener('click', function () {
  if (rExames.style.display === 'block') {
    rConsultas.style.display = 'none';
    rExames.style.display = 'none';
  } else {
    rConsultas.style.display = 'none';
    rExames.style.display = 'block';
  }
});