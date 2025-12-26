@Entity
@Table(name = "portfolio_holdings")
@Data @NoArgsConstructor
public class PortfolioHolding {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private UserPortfolio portfolio;
    @ManyToOne
    private Stock stock;
    private Double quantity;
    private BigDecimal marketValue;
    private Timestamp lastUpdated;
}