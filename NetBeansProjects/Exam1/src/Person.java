public class Person
{
    private int age;

    //other class stuff

    public void setAge(int theAge)
    {
       if(theAge<0){
           throw new IllegalArgumentException();
        }
       age = theAge;
    }
}