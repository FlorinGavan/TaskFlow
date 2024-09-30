package com.example.TaskFlow.test_mock_injection;

public class MyServiceClass {

    private DependencyOne dependencyOne;

    private DependencyTwo dependencyTwo;

    public MyServiceClass(DependencyOne dependencyOne, DependencyTwo dependencyTwo) {
        this.dependencyOne = dependencyOne;
        this.dependencyTwo = dependencyTwo;
    }
    public String useDependencies(){
        return dependencyOne.testDependency() + " " + dependencyTwo.testDependency();
    }
}
