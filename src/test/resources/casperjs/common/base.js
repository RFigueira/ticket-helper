const DEFAULT_PROFILE = 'dev';
const URL_PAGINA_ERRO_PATTERN = 'pagina-nao-existe';
const URL_PAGINA_NAO_EXISTE_PATTERN = 'problema-ocorreu';
const SELETOR_RODAPE = 'a[href="https://codepampa.com.br"]';
const require = patchRequire(require);
const p = require('./../profiles/' + (casper.cli.has('profile') ? casper.cli.get('profile') : DEFAULT_PROFILE));
const x = require('casper').selectXPath;
const c = require('./../common/constantes');



function isPaginaLogada(casper) {
    return casper.getCurrentUrl().indexOf('home') !== -1;
}

function timeoutFn() {
    this.echo("Problema de timeout");
    throw new Error('!!!Estourou o tempo! Timeout function foi invocada!');
};

function checkRenderedCompleteWithoutOps(casper, test, idSeletor, timeoutNumber) {
    timeoutNumber = timeoutNumber ? timeoutNumber : 500000;
    casper.then(
        function () {
            this.click(x('.//*[@id="'+idSeletor+'"]'));
        }).waitUntilVisible(
        SELETOR_RODAPE,
        function () {
            var url = this.getCurrentUrl();
            test.assert(url.indexOf(URL_PAGINA_ERRO_PATTERN) === (-1)
                && url.indexOf(URL_PAGINA_NAO_EXISTE_PATTERN) === (-1), 'Página abriu sem erros: ' + url);
        },
        timeoutFn, timeoutNumber);
};


exports.early = function (casper, test, manterDeslogado) {
    casper.start(p.portalUrl, function () {
        this.then(function () {
            base.logar(casper, c.loginAdmin, c.senhaAdmin);
        }).then(function () {
            if (manterDeslogado) {
                casper.then(function () {
                    base.logout();
                });
            }
            this.capture(p.screenshotsPath + 'early.png');
        });
    }).viewport(1024, 768);
};


exports.logar = function (casper, login, senha) {

};

exports.clickLabelWaitForCheckText = function (casper, test, label, selector, text, timeoutNumber) {
    timeoutNumber = timeoutNumber ? timeoutNumber : 500000;

    casper.then(
        function () {
            this.echo("Clicará em \"" + label + "\" e depois procurará através do \"" + selector + "\" pelo texto \"" + text + "\"", 'INFO');
            this.clickLabel(label, selector);
        }).waitUntilVisible(
        selector,
        function () {
            this.echo(this.getCurrentUrl() + " url atual onde tentará encontrar o texto \"" + text + "\"", 'INFO');
            test.assertSelectorHasText(selector, text);
        },
        timeoutFn, timeoutNumber);
};

exports.clickLabelWaitForRenderedCompleteWithoutError = function (casper, test, label, idSeletor, timeoutNumber) {
    timeoutNumber = timeoutNumber ? timeoutNumber : 50000;
    if (label) {
        casper.then(
            function () {
                this.click(x('.//*[@id="'+idSeletor+'"]'));

            }).waitUntilVisible(
            SELETOR_RODAPE,
            function () {
                test.assertExists(SELETOR_RODAPE);
            },
           timeoutFn, timeoutNumber);
        checkRenderedCompleteWithoutOps(casper, test, idSeletor, timeoutNumber);
    }
};



exports.logout = function (casper) {
    //Para nao executar de forma async
    casper.loadInProgress = true;
    casper.navigationRequest = true;

    casper.clickLabel(' Sair', 'a');
    casper.echo("Clicou em Sair!", 'info');
    casper.wait(800, function () {
        this.echo("esperei 0,10seg apos sair!", 'info');
    });
};

exports.checkSucess = function (casper, test, nameScreenShot, nameTest) {
    casper.then(function () {
        casper.waitForSelector("div.alert", function () {
            test.assertExists('.alert-success');
            this.echo("Como esperado: Com Sucesso! no teste " + nameTest, 'info');
            this.capture(p.screenshotsPath + nameScreenShot);
        });
    },timeoutFn, 40000);
};

exports.checkError = function (casper, test, nameScreenShot, nameTest) {
    casper.then(function () {
        casper.waitForSelector("div.alert", function () {
            test.assertExists('.alert-danger');
            this.echo("Como esperado: Com erro de validação! no teste " + nameTest, 'info');
            this.capture(p.screenshotsPath + nameScreenShot);
        });
    }, timeoutFn, 40000);
};
