public class LuckyTickets {
    public static void main(String[] args) {
        int count = 0;
        
        for (int i = 1; i <= 999999; i++) {
            int number = i;
            int[] digits = new int[6];
            
            // Разбиваем число на цифры
            for (int j = 5; j >= 0; j--) {
                digits[j] = number % 10;
                number /= 10;
            }
            
            // Проверяем условие счастливого билета
            if (digits[0] + digits[1] + digits[2] == digits[3] + digits[4] + digits[5]) {
                count++;
            }
        }
        
        System.out.println("Количество счастливых билетиков: " + count);
    }
}
