@Entity
public class RiskThreshold {

    @Id
    @GeneratedValue
    private Long id;

    private String thresholdName;
    private Double maxSingleStockPercentage;
    private Double maxSectorPercentage;
    private Boolean active;

    // getters & setters
}
