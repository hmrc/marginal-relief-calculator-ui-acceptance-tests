# marginal-relief-calculator-ui-acceptance-tests

UI test suite for the MRC using WebDriver and Cucumber.

## Running the tests

Prior to executing the tests ensure you have:

- Docker - to run mongo and browser (Chrome or Firefox) inside a container (Note - there are other ways to run Docker on the command line so this command may be different)
- Appropriate [drivers installed](#installing-local-driver-binaries) - to run tests against locally installed Browser
- Installed/configured [service manager](https://github.com/hmrc/service-manager).

BrowserStack Credentials Setup - 

Before running tests, retrieve `BROWSERSTACK_USERNAME` and `BROWSERSTACK_ACCESS_KEY` from the notes "UI Test Credentials MRC" created in the Bitwarden collection "DDCW Live Services" 
Then export them in your terminal:
export BROWSERSTACK_USERNAME="your-username"

export BROWSERSTACK_ACCESS_KEY="your-access-key"

Run the following command to start services locally:

    docker run --rm -d --name mongo -d -p 27017:27017 mongo:4.0
    sm2 --start MARGINAL_RELIEF_CALCULATOR_ALL -r --wait 100

Using the `--wait 100` argument ensures a health check is run on all the services started as part of the profile. `100`
refers to the given number of seconds to wait for services to pass health checks.

Then execute the `run-tests.sh` script:

    ./run-tests.sh chrome local

The `./run-tests.sh` script defaults to using `chrome` in the `local` environment. For a
complete list of supported param values, see:

- `src/test/resources/application.conf` for **environment**
- [ui-test-runner](https://github.com/hmrc/ui-test-runner?tab=readme-ov-file#configuration) for **browser**

## Running ZAP tests

ZAP tests can be automated through the ui-test-runner and can be toggled to run during the test execution. Running
automated ZAP tests should not be considered a substitute for manual exploratory testing using OWASP ZAP.

#### Pre-requisite for ZAP tests

In order to execute ZAP tests, it is required that the [dast-config-manager](https://github.com/hmrc/dast-config-manager) is cloned to your WORKSPACE folder. 

#### Executing a ZAP test

ZAP test execution default is set to false

To execute the ZAP tests, run the script `./run-tests.sh browser environemnt DAST` with `chrome`, `local`, `true`

## Installing local driver binaries

This project supports UI test execution using Firefox (Geckodriver) and Chrome (Chromedriver) browsers.

See the `drivers/` directory for some helpful scripts to do the installation work for you. They should work on both Mac
and Linux by running the following command:

    ./installGeckodriver.sh <operating-system> <driver-version>
    or
    ./installChromedriver <operating-system> <driver-version>

- *<operating-system>* defaults to **linux64**, however it also supports **macos**
- *<driver-version>* defaults to **0.21.0** for Gecko/Firefox, and the latest release for Chrome. You can, however,
  however pass any version available at the [Geckodriver](https://github.com/mozilla/geckodriver/tags)
  or [Chromedriver](http://chromedriver.storage.googleapis.com/) repositories.

**Note 1:** *You will need to ensure that you have a recent version of Chrome and/or Firefox installed for the later
versions of the drivers to work reliably.*

**Note 2** *These scripts use sudo to set the right permissions on the drivers so you will likely be prompted to enter
your password.*

### Scalafmt

This repository uses [Scalafmt](https://scalameta.org/scalafmt/), a code formatter for Scala. The formatting rules
configured for this repository are defined within [.scalafmt.conf](.scalafmt.conf).

To apply formatting to this repository using the configured rules in [.scalafmt.conf](.scalafmt.conf) execute:

 ```
 sbt scalafmtAll
 ```

To check files have been formatted as expected execute:

 ```
 sbt scalafmtCheckAll scalafmtSbtCheck
 ```

[Visit the official Scalafmt documentation to view a complete list of tasks which can be run.](https://scalameta.org/scalafmt/docs/installation.html#task-keys)
