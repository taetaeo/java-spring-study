package org.example;

public class Car {
    private String brand;
    private String model;
    private String color;
    private int speed;
    private boolean engineStatus;

    // 생성자
    public Car(String brand, String model, String color){
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.speed = 0;
        this.engineStatus = false;
    }

    /**
     *  void란?
     *  return 이 되는 타입이 없음을 의미하는 선언문이다.
     *  즉, 아무것도 리턴하지 않음을 선언해주어 내부적으로 함수가 실행한다.
     */
    // 엔진 시작
    public void startEngine(){
        if (!engineStatus){
            System.out.println(color + " " + brand + " " + model + "의 엔진을 시동합니다.");
            engineStatus = true;
        } else {
            System.out.println("이미 시동이 걸려 있습니다.");
        }
    }

    // 엔진 정지
    public  void stopEngine(){
        if (engineStatus) {
            System.out.println(color + " " + brand + " " + model + "의 엔진의 시동을 끄겠습니다." );
            engineStatus = false;
            speed = 0;
        }
        else {
            System.out.println("이미 엔진이 꺼져 있습니다.");
        }
    }

    // 가속
    public  void accelerate(int speedIncrease){
        if (engineStatus){
            speed += speedIncrease;
            System.out.println(color + " " + brand + " " + model + "이 " + speedIncrease + "km/h 가속하여 현재 속도는 "+ speed + "km/h 입니다.");
        }else{
            System.out.println("시동이 꺼져있어 가속할 수 없습니다.");
        }
    }
    // 감속
    public void braek(int speedDecrease) {
        if (engineStatus) {
            speed = Math.max(0, speed - speedDecrease);
            System.out.println(color + " " + brand + " " + model + "이 " + speedDecrease + "km/h 감속하여 현재 속도는 " + speed + "km/h 입니다.");
        } else {
            System.out.println("시동이 꺼져 있어 감속할 수 없습니다.");
        }
    }

    /**
     * Static이란?
     * '정적인', '고정된'이라는 뜻을 가지고 있어 클래스에 고정되어 있는 변수나 메서드이다.
     * static이 붙지 않는다면 호출할 경우 서로 다른 값을 가지고 있을 수 있다. 공통적으로 하나의 값을 유지해야할 경우 static을 사용해준다.
     * 이 때문에, 메로리에 고정적으로 할당이 된다.
     * 따라서, 특징으로는
     * 1. 메모리에 고정적으로 할당된다.
     * 2. 객체 생성 없이 사용할 수 있다.
     * 3. 프로그램이 시작되면 메모리의 static 영역에 적재되고, 프로그램이 종료될 때 해제된다.
     * 4. Static 메서드 내에서는 인스턴스 변수를 사용할 수 없다
     */

    public static void main(String[] args){
        // 자동차 인스턴스 생성
        Car myCar = new Car("현대","그랜져", "검정색");

        myCar.startEngine();
        myCar.accelerate(30);
        myCar.braek(10);
        myCar.startEngine();
    }
}
