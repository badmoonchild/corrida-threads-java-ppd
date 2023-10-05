public class CorridaThreads {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Worker(1));
        Thread thread2 = new Thread(new Worker(2));

        thread1.start();
        thread2.start();
    }

    private static class Worker implements Runnable {
        private final int id;

        public Worker(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            int totalMessages = 0;
            int maxMessages = 5; 

            while (totalMessages < maxMessages) {
                System.out.println("Thread " + id + " diz: Olá da Thread " + id);
                totalMessages++;
                
                try {
                    Thread.sleep(1000); // Espera 1 segundo entre as mensagens
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Limite de mensagens atingido na Thread " + id + ". Encerrando.");
        }
    }
}
