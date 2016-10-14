const base = require('./../common/base');


casper.test.begin('Home Web Site', 2, function suite(test) {

	base.early(casper,test);

	base.clickLabelWaitForRenderedCompleteWithoutError(casper,test, 'HOME', 'prettyLinkHome');


	casper.run(function () {
		test.done();
    });
});
