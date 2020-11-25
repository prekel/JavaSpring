using Microsoft.EntityFrameworkCore;

namespace Frankenstein.AspNet.Models
{
    public class FurnitureContext : DbContext
    {
        public FurnitureContext(DbContextOptions<FurnitureContext> options)
            : base(options)
        {
        }

        public DbSet<Furniture> Furnitures { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Furniture>(
                e =>
                {
                    e.ToTable("furniture");
                    e.HasKey(entity => entity.Id);
                    e.Property(furniture => furniture.Id)
                        .HasColumnName("id");
                    e.Property(entity => entity.Type)
                        .HasMaxLength(60)
                        .IsRequired()
                        .HasColumnName("type");
                    e.Property(entity => entity.Model)
                        .HasMaxLength(60)
                        .IsRequired()
                        .HasColumnName("model");
                    e.Property(entity => entity.Manufacturer)
                        .HasMaxLength(60)
                        .IsRequired()
                        .HasColumnName("manufacturer");
                    e.Property(entity => entity.Cost)
                        .HasColumnType("numeric(15, 2)")
                        .IsRequired()
                        .HasColumnName("cost");
                    e.Property(furniture => furniture.Height)
                        .IsRequired()
                        .HasColumnName("height");
                });
        }
    }
}
