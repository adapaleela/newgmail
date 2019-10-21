package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"E:\\testing\\way2sms\\src\\test\\resources\\feature\\feature.feature"},
				glue= {"classpath:glue"},
				plugin= {"pretty","html:target\\result"})
public class Runnerclaass 
{
}
