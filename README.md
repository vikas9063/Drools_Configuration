DROOLS in JAVA
Definition: 
Drool is a rule engine, through which we can set rules for our business logic and we can separate hard-code conditions from our business logic.
Rule engines can be used to implement complex business rules. The Drools is an open-source business rule management system that can be integrated easily with the spring boot application.
The KIE project supports the integration of the drools with other technologies like the spring boot framework.
Rules:
Rules are pieces conditions like “When some condition occurs then do the tasks”
Example:  If else statement
	When 
		(condition is true)
	Then
		(Take Desired Action)
Example
	


	
Traditional Method: 
We use if else conditins to write the logic as mentioned below
 

DroolConfig Class:
@Configuration
public class DroolConfig {

   private KieServices kieServices = KieServices.Factory.get();

   private KieFileSystem getKieFileSystem() throws IOException {
      KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
      kieFileSystem.write(ResourceFactory.newClassPathResource("rules/offer.drl"));
      return kieFileSystem;

   }

   @Bean
   public KieContainer getKieContainer() throws IOException {
      System.out.println("Container created...");
      getKieRepository();
      KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
      kb.buildAll();
      KieModule kieModule = kb.getKieModule();
      KieContainer kContainer = kieServices.newKieContainer(kieModule.getReleaseId());
      return kContainer;

   }

   private void getKieRepository() {
      final KieRepository kieRepository = kieServices.getRepository();
      kieRepository.addKieModule(new KieModule() {
         public ReleaseId getReleaseId() {
            return kieRepository.getDefaultReleaseId();
         }
      });
   }

   @Bean
   public KieSession getKieSession() throws IOException {
      System.out.println("session created...");
      return getKieContainer().newKieSession();

   }


The configuration class defines a spring bean KieContainer. The KieContainer is used to build the rule engine by loading the rule files under the application’s /resources folder.
We create the KieFileSystem instance and configure the rule engine and load the DRL file from the application’s resources directory.
Also, we can use the KieBuilder instance to build the drools module. We can use the KieSerive singleton instance to create the KieBuilder instance.
Finally, we use KieService to create a KieContainer and configure it as a spring bean.

And in Controller class we use like mentioned below
@Autowired
private KieSession kieSession;

@PostMapping("/order")
public ResponseEntity<Order> orderNow(@RequestBody Order order) {

   kieSession.insert(order);
   kieSession.fireAllRules();

   return ResponseEntity.ok().body(order);
}



