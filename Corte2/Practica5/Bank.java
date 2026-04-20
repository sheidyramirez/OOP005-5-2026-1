
public class Bank{
  private CheckingAccount accountOne;
  private CheckingAccount accountTwo;
  private CheckingAccount accountThree;
  private CheckingAccount accountFour; 
  private CheckingAccount accountFive; 
  private CheckingAccount accountSix; 

  public Bank(){
    accountOne = new CheckingAccount("Zeus", 100, "1");
    accountTwo = new CheckingAccount("Hades", 200, "2");
    accountThree = new CheckingAccount("Afrodita", 300, "3");
    accountFour = new CheckingAccount("Atenea", 400, "4");
    accountFive = new CheckingAccount("Cronos", 500, "5");
    accountSix = new CheckingAccount("Poseidon", 600, "6");
  }

  public static void main(String[] args){
    Bank bankOfGods = new Bank();
    System.out.println(bankOfGods.accountSix.getBalance());
    bankOfGods.accountSix.setBalance(5000);
    System.out.println(bankOfGods.accountSix.getBalance());
    System.out.println(bankOfGods.accountSix.getMonthlyInterest());

  }
}
