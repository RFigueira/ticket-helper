function HomePage() {
    this.clickHome = function() {
        casper.then(function() {
            this.click('a[id="prettyLinkHome"]');
        });
    };
}