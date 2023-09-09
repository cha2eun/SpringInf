package hello.core.singleton;

public class SingletonService {
    //static
    // 자기자신을 내부에 private static으로 하나 가지고있음 -> class레벨에 올라가서 딱 하나만 존재하게됨
    private static final SingletonService instance = new SingletonService();

    // JVM이 뜰 때 이 객체를 실행해서 자기 자신을 생성한 뒤 instance에 참조로 넣어둠
    public static SingletonService getInstance(){
        return instance;
    }

    // private으로 막아두면 외부에서 new로 새 객체 생성 시도하는걸 방지할 수 있음
    private SingletonService(){
    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
