package data;
/**
 * Created by Вадим on 08.04.2016.
 */
public class DAO {

    final private String Name;
    final private String Mail;
    final private String Number;
    final private String VkId;

    public DAO(String Name, String Mail, String Number, String VkId){
        this.Name = Name;
        this.Mail = Mail;
        this.Number = Number;
        this.VkId = VkId;
    }
   /* public void setVkId(String vkId) {
        VkId = vkId;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public void setName(String name) {
        Name = name;
    }*/

    public String getVkId() {
        return VkId;
    }

    public String getMail() {
        return Mail;
    }

    public String getNumber() {
        return Number;
    }

    public String getName() {
        return Name;
    }
}
