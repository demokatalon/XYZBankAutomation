package xyzkey
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class XYZkeyword {


	@Keyword
	def openbrowser(String url) {

		WebUI.openBrowser(GlobalVariable.url)
		WebUI.maximizeWindow()
	}

	@Keyword
	def closebrowser() {

		WebUI.closeBrowser()
	}

	@Keyword
	def Logout() {

		WebUI.click(findTestObject('Object Repository/Login/Page_XYZ Bank/button_Logout'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Login/Page_XYZ Bank/button_Home'), 0)
	}


	@Keyword
	def Login (String username) {

		WebUI.click(findTestObject('Object Repository/Login/Page_XYZ Bank/button_Customer Login'))

		WebUI.selectOptionByLabel(findTestObject('Object Repository/Login/Page_XYZ Bank/select_---Your Name---       Hermoine Grang_6e895b'), GlobalVariable.loginname,false)

		WebUI.click(findTestObject('Object Repository/Login/Page_XYZ Bank/button_Login'))

		WebUI.verifyElementPresent(findTestObject('Object Repository/Login/Page_XYZ Bank/WelcomeBanner'), 1)
	}

	@Keyword
	def depositdummy(String amount) {

		WebUI.selectOptionByIndex((findTestObject('Object Repository/Dashboard/selectAccountNo')), 1)
		WebUI.click(findTestObject('Object Repository/Dashboard/btnDeposit'))
		WebUI.delay(2)
		WebUI.setText(findTestObject('Object Repository/Page_XYZ Bank/input_Amount to be Deposited_form-control n_97f4dd'),GlobalVariable.damount)
		WebUI.click(findTestObject('Object Repository/Deposits/btnDeposit'))
		WebUI.verifyElementText(findTestObject('Object Repository/Withdrawls/confirmMessage'), 'Deposit Successful')
	}

	@Keyword
	def deposit(String amount) {

		WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_Deposit'))

		WebUI.setText(findTestObject('Object Repository/Page_XYZ Bank/input_Amount to be Deposited_form-control n_97f4dd'), '1555')

		WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_Deposit_1'))

		WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/span_Deposit Successful'))

		WebUI.verifyElementText(findTestObject('Object Repository/Page_XYZ Bank/span_Deposit Successful'), 'Deposit Successful')
	}

	@Keyword
	def Withdrawl(String amount) {

		WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_Withdrawl'))

		WebUI.setText(findTestObject('Object Repository/Page_XYZ Bank/input_Amount to be Deposited_form-control n_97f4dd'), '500')

		WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_Withdraw'))

		WebUI.verifyElementText(findTestObject('Object Repository/Page_XYZ Bank/span_Transaction successful'), 'Transaction successful')
	}
	
	@Keyword
	def WithdrawlExcessamount(String amount) {

		WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_Withdrawl'))

		WebUI.setText(findTestObject('Object Repository/Page_XYZ Bank/input_Amount to be Deposited_form-control n_97f4dd'), '100000')

		WebUI.click(findTestObject('Object Repository/Page_XYZ Bank/button_Withdraw'))

		WebUI.verifyElementText(findTestObject('Object Repository/Page_XYZ Bank/span_Transaction successful'), 'Transaction Failed. You can not withdraw amount more than the balance.')
	}
	
	
	
	
}
