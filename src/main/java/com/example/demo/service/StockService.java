@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock getStockById(Long id) {
        return stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found with id " + id));
    }

    public Stock updateStock(Long id, Stock updatedStock) {
        Stock stock = getStockById(id);
        stock.setTicker(updatedStock.getTicker());
        stock.setCompanyName(updatedStock.getCompanyName());
        stock.setSector(updatedStock.getSector());
        stock.setActive(updatedStock.isActive());
        return stockRepository.save(stock);
    }

    // ✅ HARD DELETE
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
