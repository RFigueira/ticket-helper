//function verificarMarcados() {
//
//    $('.rbtnRaiz input').trigger('change');
//    $('.rbtnCaule input').trigger('change');
//    $('.rbtnCopa input').trigger('change');
//}
//
//$(document).ready(function () {
//
//    $('.rbtnRaiz input').change(function () {
//        if ($(this).val() === 'false') {
//            $(".divRaiz").show();
//        }
//        else
//        {
//            $(".divRaiz").hide();
//            $("input[type=checkbox][data-tipo=problema_raiz]").attr('checked', false);
//        }
//    });
//
//    $('.rbtnCaule input').change(function () {
//        if ($(this).val() === 'false') {
//            $(".divCaule").show();
//        }
//        else
//        {
//            $(".divCaule").hide();
//            $("input[type=checkbox][data-tipo=problema_caule]").attr('checked', false);
//        }
//    });
//
//    $('.rbtnCopa input').change(function () {
//        if ($(this).val() === 'true') {
//            $(".divCopa").show();
//        }
//        else
//        {
//            $(".divCopa").hide();
//            $("input[type=checkbox][data-tipo=problema_copa]").attr('checked', false);
//        }
//    });
//
//    $(".cbOutrosDoencaPragas").click(function () {
//        if ($(this).is(':checked')) {
//            $(".divDoencaPraga").show();
//        } else {
//            $(".divDoencaPraga").hide();
//            $("input[type=checkbox][data-tipo=doenca_praga]").attr('checked', false);
//            //$("option[data-tipo=nivel_erva_passarinho]").attr('selected', true);
//            //$(".nivelEravaPassarinho").hide();
//        }
//
//    });
//    $(".cbErvaPassarinho").click(function () {
//        if ($(this).is(':checked')) {
//            $(".divNivelEravaPassarinho").show();
//        } else {
//            $(".divNivelEravaPassarinho").hide();
//            // $("input[type=checkbox][data-tipo=doenca_praga]").attr('checked', false);
//            $("option[data-tipo=nivel_erva_passarinho]").attr('selected', true);
//            //$(".nivelEravaPassarinho").hide();
//        }
//
//    });
//
//    //Manejo
//
//    $('.rbtnManejoRaiz input').change(function () {
//        if ($(this).val() === 'true') {
//            $(".divManejoRaiz").show();
//        }
//        else
//        {
//            $(".divManejoRaiz").hide();
//            $("input[type=checkbox][data-tipo=manejo_raiz]").attr('checked', false);
//        }
//    });
//
//    $('.rbtnManejoCaule input').change(function () {
//        if ($(this).val() === 'true') {
//            $(".divManejoCaule").show();
//        }
//        else
//        {
//            $(".divManejoCaule").hide();
//            $("input[type=checkbox][data-tipo=manejo_caule]").attr('checked', false);
//        }
//    });
//    $('.rbtnManejoCopa input').change(function () {
//        if ($(this).val() === 'true') {
//            $(".divManejoCopa").show();
//        }
//        else
//        {
//            $(".divManejoCopa").hide();
//            $("input[type=checkbox][data-tipo=manejo_copa]").attr('checked', false);
//        }
//    });
//
//    $('.rbtnManejoDoencaPraga input').change(function () {
//        if ($(this).val() === 'true') {
//            $(".divManejoDoencaPraga").show();
//        }
//        else
//        {
//            $(".divManejoDoencaPraga").hide();
//            $(".divTextAreaOutrosDoencaPraga").hide();
//
//            $("input[type=checkbox][data-tipo=manejo_doenca_praga]").attr('checked', false);
//        }
//    });
//    $(".cbOutrosDoencaPragas").click(function () {
//        if ($(this).is(':checked')) {
//            $(".divTextAreaOutrosDoencaPraga").show();
//        } else {
//            $(".divTextAreaOutrosDoencaPraga").hide();
//            // $("input[type=checkbox][data-tipo=doenca_praga]").attr('checked', false);
//            //$("option[data-tipo=nivel_erva_passarinho]").attr('selected', true);
//            //$(".nivelEravaPassarinho").hide();
//        }
//
//    });
//    $(".opt-estado-atual").change(function () {
//        // console.log('g');
//        if ($('option:selected', this).val() == '3') {
//            $(".divDadosDetalhados").hide();
//            $(".divDadosMorta").show();
//
//        } else {
//            $(".divDadosDetalhados").show();
//            $(".divDadosMorta").hide();
//
//        }
//    });
//
//    $(".cbSugerirEspecie").click(function () {
//        if ($(this).is(':checked')) {
//            $(".divSujestaoEspecie").show();
//        } else {
//            $(".divSujestaoEspecie").hide();
//        }
//
//    });
//
//});
//
//
//
//verificarMarcados();


//$(".link-home").click(function () {
//    console.log("asda");
//    $(this).addClass('codepampa-selected-menu-top');
//    $(".link-contato").removeClass('codepampa-selected-menu-top');
//    $(".link-noticias").removeClass('codepampa-selected-menu-top');
//    $(".link-quemsomos").removeClass('codepampa-selected-menu-top');
//
//
//});
//$(".link-noticias").click(function () {
//    $(".link-noticias").addClass('codepampa-selected-menu-top');
//    $(".link-home").removeClass('codepampa-selected-menu-top');
//    $(".link-contato").removeClass('codepampa-selected-menu-top');
//    $(".link-quemsomos").removeClass('codepampa-selected-menu-top');
//
//
//});



//$(document).ready(function () {
//
//    
//    function visibilidadeDivsComCheck(el){
//       if (el.is(':checked')) {// testo o active da classe do botão
//            el.parent().parent().parent().next('.visibilidade').show();
//        } else {
//            el.parent().parent().parent().next('.visibilidade').hide();
//        }
//    }
//    $(".cbProblemaNaCopa").click(function () {
//        visibilidadeDivsComCheck($(this));
//    });
//
//    $(".cbProblemaNoCaule").click(function () {
//        visibilidadeDivsComCheck($(this));
//    });
//
//
//
//    $(".poda").change(function () {
//        var valor = $(this).val();
//        if (valor === '3') {// testo o active da classe do botão
//            $(".problemaNaPoda").show();
//        } else {
//            $(".problemaNaPoda").hide();
//        }
//    });
//
//
//    $(".raiz").change(function () {
//        var valor = $(this).val();
//        if (valor === '2') {// testo o active da classe do botão
//            $(".problemaNaRaizNivel1").show();
//        } else {
//            $(".problemaNaRaizNivel1").hide();
//        }
//    });
//
//
//    $(".ofereceRisco").click(function () {
//         visibilidadeDivsComCheck($(this));
//    });
//
//    $(".cbCausaDanos").click(function () {
//          visibilidadeDivsComCheck($(this));
//    });
//
//    $(".cbPodaCopa").click(function () {
//          visibilidadeDivsComCheck($(this));
//    });
//
//    $(".cbSupressao").click(function () {
//          visibilidadeDivsComCheck($(this));
//    });
//
//    $(".cbErvaPassarinho").click(function () {
//          visibilidadeDivsComCheck($(this));
//    });
//
//
//});



///Vai dentro da function pai
//    $(".cbProblemaNaCopa").click(function () {
//        if ($(this).is(':checked')) {
//            $(".problemaNaCopa").show();
//        } else {
//            $(".problemaNaCopa").hide();
//            $("input[type=checkbox][data-tipo=problema_copa]").attr('checked', false);
//            $("option[data-tipo=nivel_erva_passarinho]").attr('selected', true);
//            $(".nivelEravaPassarinho").hide();
//        }
//    });
//
//    $(".cbProblemaNoCaule").click(function () {
//        if ($(this).is(':checked')) {
//            $(".problemaNoCaule").show();
//        } else {
//            $(".problemaNoCaule").hide();
//            $("input[type=checkbox][data-tipo=problema_caule]").attr('checked', false);
//
//        }
//    });
//
//    $(".poda").change(function () {
//        var valor = $(this).val();
//        if (valor === '3') {
//            $(".problemaNaPoda").show();
//        } else {
//            $(".problemaNaPoda").hide();
//            $("input[type=checkbox][data-tipo=problema_poda]").attr('checked', false);
//
//
//        }
//    });
//
//    $(".raiz").change(function () {
//        var valor = $(this).val();
//        if (valor === '2') {
//            $(".problemaNaRaizNivel1").show();
//        } else {
//            $(".problemaNaRaizNivel1").hide();
//            $("input[type=checkbox][data-tipo=problema_raiz]").attr('checked', false);
//            $("input[type=checkbox][data-tipo=causa_dano]").attr('checked', false);
//            $("option[data-tipo=nivel_risco_caminhante]").attr('selected', true);
//            $(".nivelRiscoAoCaminhante").hide();
//            $(".danosCausadosA").hide();
//
//
//
//        }
//    });
//
//
//    $(".ofereceRisco").click(function () {
//        if ($(this).is(':checked')) {
//            $(".nivelRiscoAoCaminhante").show();
//            $("option[data-tipo=nivel_risco_caminhante]").attr('selected', false);
//
//        } else {
//            $(".nivelRiscoAoCaminhante").hide();
//            $("option[data-tipo=nivel_risco_caminhante]").attr('selected', true);
//
//        }
//    });
//
//    $(".cbCausaDanos").click(function () {
//        if ($(this).is(':checked')) {
//            $(".danosCausadosA").show();
//        } else {
//            $(".danosCausadosA").hide();
//            $("input[type=checkbox][data-tipo=causa_dano]").attr('checked', false);
//
//        }
//    });
//
//    $(".cbPodaCopa").click(function () {
//        if ($(this).is(':checked')) {
//            $(".manejoDaCopa").show();
//        } else {
//            $(".manejoDaCopa").hide();
//            $("input[type=checkbox][data-tipo=manejo_copa]").attr('checked', false);
//
//        }
//    });
//
//    $(".cbSupresao").click(function () {
//        if ($(this).is(':checked')) {
//            $(".tipoSupresao").show();
//            $("option[data-tipo=tipo_supressao]").attr('selected', false);
//
//        } else {
//            $(".tipoSupresao").hide();
//            $("option[data-tipo=tipo_supressao]").attr('selected', true);
//
//        }
//    });
//
//    $(".cbErvaPassarinho").click(function () {
//        if ($(this).is(':checked')) {
//            $(".nivelEravaPassarinho").show();
//            $("option[data-tipo=nivel_erva_passarinho]").attr('selected', false);
//
//        } else {
//            $(".nivelEravaPassarinho").hide();
//            $("option[data-tipo=nivel_erva_passarinho]").attr('selected', true);
//
//        }
//    });
